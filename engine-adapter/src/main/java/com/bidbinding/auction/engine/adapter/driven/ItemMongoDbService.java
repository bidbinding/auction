package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ItemMongoDbService {

    MongoClient mongoClient;

    @Autowired
    public ItemMongoDbService(@Value("mongodb.url") String mongodbUrl) {
        this(MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(mongodbUrl))
                        .retryWrites(true)
                        .build()
        ));
    }

    ItemMongoDbService(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public Observable<InsertOneResult> asyncWriteItemToDatastore(ForwardAuctionItem item) {
        MongoDatabase database = mongoClient.getDatabase("bidbinding");
        MongoCollection<ForwardAuctionItem> collection = database.getCollection("forward_auction", ForwardAuctionItem.class);

        Publisher<InsertOneResult> result = collection.insertOne(item);

        return Observable.fromPublisher(result);
    }

    public void concludeInCache(ForwardAuctionItem item) {

    }
}
