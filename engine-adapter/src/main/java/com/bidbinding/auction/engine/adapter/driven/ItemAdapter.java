package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.adapter.common.Adaptor;
import com.bidbinding.auction.engine.application.core.model.bid.BidsHistory;
import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import com.bidbinding.auction.engine.application.core.model.item.ItemAuctionState;
import com.bidbinding.auction.engine.application.core.model.item.ItemAuctionType;
import com.bidbinding.auction.engine.application.port.driven.ItemPort;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Adaptor
public class ItemAdapter implements ItemPort<ForwardAuctionItem> {

    //TODO mfguven : Why is Adapter a Port?
    // ItemAdapter should be supporting all auction item types NOT only ForwardAuctionItem
    // We might nee three separate ItemPort's for each auction type.

    private final BehaviorSubject<ForwardAuctionItem> itemBehaviorSubject;

    //TODO mfguven : How many of these thread pools do we have?
    // Should we keep one thread pool per application instance?
    private final ExecutorService threadPool;

    public ItemAdapter(
            ItemTimestreamService itemTimestreamService,
            ItemMongoDbService itemMongoDbService,
            ItemRedisService itemRedisService
    ) {
        this.threadPool = Executors.newCachedThreadPool();
        this.itemBehaviorSubject = BehaviorSubject.create();
        this.itemBehaviorSubject.subscribe(item -> {
            itemTimestreamService.asyncRecordImmutableBid(item);
            itemMongoDbService.asyncWriteItemToDatastore(item);
            itemRedisService.asyncWriteItemToCache(item);
        });
    }

    @Override
    public ItemAuctionType getListingTypeFor(String itemId) {
        return ItemAuctionType.FORWARD;
    }

    @Override
    public void updateItem(ForwardAuctionItem item) {
        threadPool.submit(() -> itemBehaviorSubject.onNext(item));
    }

    @Override
    public ForwardAuctionItem getItem(String itemId) {
        return ForwardAuctionItem.builder()
                .id(UUID.randomUUID().toString())
                .itemAuctionState(ItemAuctionState.STARTED)
                .bidsHistory(new BidsHistory())
                .startedAt(Instant.now())
                .finishedAt(Instant.now())
                .build();
    }

}
