package com.bidbinding.auction.engine.application.port.driven;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;

public interface AuctionPort {
    boolean canPlaceBid(Bid bid);

    void placeBid(Bid bid);

}
