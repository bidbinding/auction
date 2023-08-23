package com.bidbinding.auction.engine.adapter.driven.dto;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import lombok.Data;

@Data
public class BidFraudDto {

    private Bid bid; //TODO mfguven : We may be using the wrong type here.
    private String onItemId;

}
