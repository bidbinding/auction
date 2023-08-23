package com.bidbinding.auction.engine.adapter.driven.dto;

import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import com.bidbinding.auction.engine.application.core.model.item.ItemAuctionType;
import com.bidbinding.auction.engine.application.core.model.item.ReverseAuctionItem;

public class ItemAdaptor {

    public static ForwardAuctionItem toForward(ItemForwardEntity itemForward) {
        return ForwardAuctionItem.builder()
                .id(itemForward.getItemId())
                .build();
    }

    public static ItemDto from(ForwardAuctionItem itemForward) {
        return null;
    }

    public static ReverseAuctionItem toReverse(ItemDto dto) {
        return null;
    }

    public static ItemDto from(ReverseAuctionItem itemReverse) {
        return null;
    }
}
