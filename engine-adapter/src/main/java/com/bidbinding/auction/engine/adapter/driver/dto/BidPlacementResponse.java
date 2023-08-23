package com.bidbinding.auction.engine.adapter.driver.dto;

import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BidPlacementResponse implements Serializable {
    BidPlacementStatus status;
}
