package com.bidbinding.auction.engine.adapter.driven.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class BidAdapter {

    public static com.bidbinding.auction.engine.application.core.model.bid.Bid toModel(BidEntity bid) {
        return com.bidbinding.auction.engine.application.core.model.bid.Bid.builder()
                .amount(BigDecimal.valueOf(bid.getAmount()))
                .buyer(bid.getBuyer())
                .id(bid.getBid_id())
                .build();
    }

    public static com.bidbinding.auction.engine.application.core.model.bid.Bid toModel(com.bidbinding.auction.engine.adapter.driver.dto.BidPlacementRequest bidPlacementRequest) {
        return com.bidbinding.auction.engine.application.core.model.bid.Bid.builder()
                .id(UUID.randomUUID().toString())
                .buyer(bidPlacementRequest.getBidder())
                .amount(bidPlacementRequest.getAmount())
                .build();
    }

    public static List<com.bidbinding.auction.engine.application.core.model.bid.Bid> toModel(List<BidEntity> bids) {
        return bids.stream()
                .map(BidAdapter::toModel)
                .collect(Collectors.toList());
    }


    public static BidEntity toDto(com.bidbinding.auction.engine.application.core.model.bid.Bid bid, int itemId) {
        return BidEntity.builder()
                .itemId(itemId)
                .amount(bid.getAmount().floatValue())
                .buyer(bid.getBuyer())
                .build();
    }
}
