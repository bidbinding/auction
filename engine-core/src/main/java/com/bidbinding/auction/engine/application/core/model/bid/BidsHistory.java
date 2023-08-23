package com.bidbinding.auction.engine.application.core.model.bid;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BidsHistory {

    private List<Bid> bids;
    private List<Bid> rejectedBids;
    private Map<String, String> detectedFraudulentBids;
    private Bid winningBid;

    public BidsHistory() {
        this.bids = new ArrayList<>();
        this.rejectedBids = new ArrayList<>();
        this.detectedFraudulentBids = new HashMap<>();
        this.winningBid = null;
    }

    public BidsHistory(
            List<Bid> bids,
            List<Bid> rejectedBids,
            Map<String, String> detectedFraudulentBids,
            Bid winningBid
    ) {
        this.bids = bids;
        this.rejectedBids = rejectedBids;
        this.detectedFraudulentBids = detectedFraudulentBids;
        this.winningBid = winningBid;
    }

    public boolean bidderAttemptedFraudOnThisItemAlready(String bidder) {
        return detectedFraudulentBids.containsKey(bidder);
    }

    public boolean isThereAPreviousWinner() {
        return winningBid != null;
    }

    public boolean isWinningBidOutbid(BigDecimal amount) {
        return winningBid == null || winningBid.getAmount().compareTo(amount) < 0;
    }
}
