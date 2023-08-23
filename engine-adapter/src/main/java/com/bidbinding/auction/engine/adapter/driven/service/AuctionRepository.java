package com.bidbinding.auction.engine.adapter.driven.service;

import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;

public interface AuctionRepository {
    ForwardAuctionItem getForwardAuctionItem(String itemId);

    void updateForwardItem(ForwardAuctionItem item);
}
