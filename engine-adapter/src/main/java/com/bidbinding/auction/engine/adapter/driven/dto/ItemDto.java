package com.bidbinding.auction.engine.adapter.driven.dto;

import com.bidbinding.auction.engine.application.core.model.item.ItemAuctionType;
import lombok.Data;

@Data
public class ItemDto {

    private ItemAuctionType itemBiddingType;
    private String id;


}
