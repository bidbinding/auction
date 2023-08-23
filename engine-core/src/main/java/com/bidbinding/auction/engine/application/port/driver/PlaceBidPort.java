package com.bidbinding.auction.engine.application.port.driver;

import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import com.bidbinding.auction.engine.application.core.model.bid.ItemBidCommand;

public interface PlaceBidPort {

    BidPlacementStatus placeBid(ItemBidCommand itemBidCommand);

}
