package com.bidbinding.auction.engine.adapter.driven.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "bid")
@Table(name = "bid")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BidEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id; //TODO mfguven : We may not be needing this column. Could bid_id be used?

    @Column(name = "bid_id")
    private String bid_id; //TODO mfguven : this cloumn should be id. bid_id is unique.

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "winner")
    private String winner;

    @NotNull
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "amount")
    private float amount; //TODO mfguven : Why float? Shouldn't it be BigDecimal?

}
