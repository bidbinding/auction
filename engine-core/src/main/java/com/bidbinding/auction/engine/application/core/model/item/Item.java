package com.bidbinding.auction.engine.application.core.model.item;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;


public sealed interface Item permits ForwardAuctionItem, ReverseAuctionItem, SealedBidItem {

    String getTenantId();

    BidPlacementStatus recordBid(Bid bid);

    void cancel();

    void conclude();

    boolean isAuctionEnded();

    boolean isAuctionNotStarted();

    boolean isAuctionConcluded();
}
