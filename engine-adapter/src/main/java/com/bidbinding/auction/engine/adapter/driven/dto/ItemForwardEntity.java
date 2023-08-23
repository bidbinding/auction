package com.bidbinding.auction.engine.adapter.driven.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "item_forward")
@Table(name = "item_forward")
@Data
public class ItemForwardEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id; //TODO mfguven : We may not be needing this column. Could bid_id be used?

    @NotNull
    @Column(name = "item_id")
    private String itemId; //TODO mfguven : this column should be id. bid_id is unique.

    @Column(name = "description")
    private String description;

}
