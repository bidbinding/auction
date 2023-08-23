package com.bidbinding.auction.engine.application.port.driven;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidNotification;

public interface EventPort {


    void itemConcluded(String itemId);

    void itemWon(String itemId);

    void itemReserveNotMet(String itemId);

    void bidFailed(BidNotification bidNotificationCommand);

    void bidPlaced(Bid bid);
}
