package com.bidbinding.auction.engine.application.core.model.bid;

import com.bidbinding.auction.engine.application.core.model.fraud.FraudDetectionResult;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@RequiredArgsConstructor
@Getter
public class Bid {

    //TODO mfguven : We should move non-final fields to a separate class.

    private final String id;
    private final BigDecimal amount;
    private final String buyer;
    private final Instant timestamp; //TODO mfguven : Timestamp of what?
    private BidPlacementStatus bidPlacementStatus;
    private FraudDetectionResult fraudDetectionResult;

    public void markAsFraud(FraudDetectionResult fraudDetectionResult) {
        this.fraudDetectionResult = fraudDetectionResult;
        this.bidPlacementStatus = BidPlacementStatus.REJECTED_DUE_TO_FRAUD;
    }
}
