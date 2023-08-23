package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.adapter.common.Adaptor;
import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidNotification;
import com.bidbinding.auction.engine.application.port.driven.EventPort;
import org.springframework.stereotype.Component;

@Adaptor
public class EventPortAdapter implements EventPort {


    @Override
    public void itemConcluded(String itemId) {
        System.out.println("EVENT: Auction concluded");
    }

    @Override
    public void itemWon(String itemId) {
        System.out.println("EVENT: Item won");
    }

    @Override
    public void itemReserveNotMet(String itemId) {
        System.out.println("EVENT: Item reserved price not met");
    }

    @Override
    public void bidFailed(BidNotification bidNotificationCommand) {
        System.out.println("EVENT: Bid failed");
    }

    @Override
    public void bidPlaced(Bid bid) {
        System.out.println("EVENT: bid placed: bid id = "+bid.getId());
    }


}
