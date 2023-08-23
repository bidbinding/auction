package com.bidbinding.auction.engine.adapter.driver.dto;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;

import java.util.UUID;

public class BidPlacementConverter {

    public static Bid toBid(BidPlacementRequest request) {
        return Bid.builder()
                .id(UUID.randomUUID().toString())
                .buyer(request.getBidder())
                .amount(request.getAmount())
                .bidPlacementStatus(BidPlacementStatus.PENDING)
                .build();
    }

}
