package com.bidbinding.auction.engine.adapter.driven.dto;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;

public class BidFraudAdaptor {

    public static BidFraudDto dtoFrom(Bid bid) {
        BidFraudDto bidFraudDto = new BidFraudDto();
        bidFraudDto.setBid(bid);
        return bidFraudDto;
    }

    public static Bid bidFrom(BidFraudDto bidFraudDto) {
        return null;
    }

}
