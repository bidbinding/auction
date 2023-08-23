package com.bidbinding.auction.engine.adapter.common.driven;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TimestreamConfiguration {

    //TODO mfguven : Why is this a common class. It is so obvious that this config is AWS related.

    private String region;
    private String database;
    private String table;

}
