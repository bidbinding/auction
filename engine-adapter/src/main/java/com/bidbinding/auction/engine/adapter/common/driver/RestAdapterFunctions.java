package com.bidbinding.auction.engine.adapter.common.driver;

import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import org.springframework.http.HttpStatus;

public final class RestAdapterFunctions {

    public static HttpStatus toHttpStatus(BidPlacementStatus bidPlacementStatus) {
        return switch (bidPlacementStatus) {
            case REJECTED -> HttpStatus.BAD_REQUEST;
            case ACCEPTED -> HttpStatus.OK;
            default -> HttpStatus.NOT_ACCEPTABLE;
        };
    }
}
