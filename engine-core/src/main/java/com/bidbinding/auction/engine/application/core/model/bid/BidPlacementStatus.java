package com.bidbinding.auction.engine.application.core.model.bid;

public enum BidPlacementStatus {
    PENDING,
    ACCEPTED,
    REJECTED,
    REJECTED_DUE_TO_FRAUD;


    public boolean isPending() {
        return this == PENDING;
    }
    public boolean isAccepted() {
        return this == ACCEPTED;
    }

    public boolean isRejected() {
        return this == REJECTED;
    }

    public boolean isFraud() {
        return this == REJECTED_DUE_TO_FRAUD;
    }
}
