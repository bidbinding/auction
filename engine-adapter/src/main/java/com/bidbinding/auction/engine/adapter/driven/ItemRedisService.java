package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRedisService {

    public Observable<String> asyncWriteItemToCache(ForwardAuctionItem item) {
        return Observable.just("stored in in cache");
    }

    public void concludeInCache(ForwardAuctionItem item) {

    }

}
