package com.bidbinding.auction.engine.application.core.model.item;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import com.bidbinding.auction.engine.application.core.model.bid.BidsHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public final class ForwardAuctionItem implements Item {

    private final String id;
    private String tenantId;

    private Bid bid;

    //TODO mfguven : When is this field set and where it is being used
    private final BigDecimal reservedPrice;
    private final Instant startedAt;
    private final Instant finishedAt;

    private ItemAuctionState itemAuctionState;
    private Instant concludedAt;

    private transient BidsHistory bidsHistory;

    public void storeForTenant(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public BidPlacementStatus recordBid(Bid bid) {
        if (!bid.getBidPlacementStatus().isFraud()) {
            bid.setBidPlacementStatus(
                    canPlaceBid(bid)
                            ? BidPlacementStatus.ACCEPTED
                            : BidPlacementStatus.REJECTED
            );
        }
        this.bid = bid;
        return bid.getBidPlacementStatus();
    }

    @Override
    public void conclude() {
        if (isAuctionEnded() || isAuctionNotStarted()) {
            itemAuctionState = ItemAuctionState.CONCLUDED;
            this.concludedAt = Instant.now();
        }
    }

    @Override
    public void cancel() {
        itemAuctionState = ItemAuctionState.CANCELLED;
    }

    private boolean canPlaceBid(Bid bid) {
        if (isAuctionNotStarted() || isAuctionEnded()) return false;
        if (bidsHistory.bidderAttemptedFraudOnThisItemAlready(bid.getBuyer())) return false;
        return isIncomingBidAmountIsLargerThanCurrentWinningBid(bid);
    }

    private boolean isIncomingBidAmountIsLargerThanCurrentWinningBid(Bid bid) {
        return bidsHistory.isThereAPreviousWinner() && bidsHistory.isWinningBidOutbid(bid.getAmount());
    }

    @Override
    public boolean isAuctionEnded() {
        //TODO mfguven : We need to be clear on deciding state by time or ItemAuctionState
        return finishedAt.isBefore(Instant.now());
    }

    @Override
    public boolean isAuctionNotStarted() {
        //TODO mfguven : We need to be clear on deciding state by time or ItemAuctionState
        return startedAt.isAfter(Instant.now());
    }

    @Override
    public boolean isAuctionConcluded() {
        return itemAuctionState == ItemAuctionState.CONCLUDED;
    }


}
