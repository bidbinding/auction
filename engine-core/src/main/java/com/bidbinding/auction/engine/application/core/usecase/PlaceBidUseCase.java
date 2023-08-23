package com.bidbinding.auction.engine.application.core.usecase;

import com.bidbinding.auction.engine.application.core.common.UseCase;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import com.bidbinding.auction.engine.application.core.model.bid.ItemBidCommand;
import com.bidbinding.auction.engine.application.core.model.item.ItemAuctionType;
import com.bidbinding.auction.engine.application.port.driven.ItemPort;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class PlaceBidUseCase  {

    private ForwardAuctionUseCase forwardAuctionUsecase;
    private SealedBidsUseCase sealedBidsUsecase;
    private ReverseAuctionUseCase reverseAuctionUsecase;
    private ItemPort<?> itemPort;


    public ItemAuctionType detectAuctionType(String itemId) {
        return itemPort.getListingTypeFor(itemId);
    }

    public BidPlacementStatus placeBid(ItemBidCommand itemBidCommand) {
        ItemAuctionType type = detectAuctionType(itemBidCommand.onItemId());
        return switch (type) {
            case FORWARD -> forwardAuctionUsecase.placeBid(itemBidCommand.bid(), itemBidCommand.onItemId());
            case REVERSE -> throw new UnsupportedOperationException("Reverse Auction is not supported");
            case SEALED_BID -> throw new UnsupportedOperationException("Sealed Bid Auction is not supported");
        };
    }
}
