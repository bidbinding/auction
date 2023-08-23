package com.bidbinding.auction.engine.adapter.driver.dto;

import com.bidbinding.auction.engine.adapter.driver.validator.Money;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BidPlacementRequest {
    @NotBlank(message = "missing.bidder")
    String bidder;
    @NotBlank(message = "missing.item")
    String itemId;
    @NotNull(message = "missing.amount") @Money
    BigDecimal amount;
}
