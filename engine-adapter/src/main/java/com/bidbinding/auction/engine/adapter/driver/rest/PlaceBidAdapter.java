package com.bidbinding.auction.engine.adapter.driver.rest;

import com.bidbinding.auction.engine.adapter.driver.dto.BidPlacementRequest;
import com.bidbinding.auction.engine.adapter.driver.dto.BidPlacementResponse;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import com.bidbinding.auction.engine.application.core.model.bid.ItemBidCommand;
import com.bidbinding.auction.engine.application.core.usecase.PlaceBidUseCase;
import com.bidbinding.auction.engine.application.port.driver.PlaceBidPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static com.bidbinding.auction.engine.adapter.common.driver.RestAdapterFunctions.toHttpStatus;
import static com.bidbinding.auction.engine.adapter.driver.dto.BidPlacementConverter.toBid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PlaceBidAdapter implements PlaceBidPort {

    //TODO mfguven : Why is Adapter a Port?
    // Is it allowed?

    private final PlaceBidUseCase placeBidUsecase;

    @Autowired
    public PlaceBidAdapter(PlaceBidUseCase placeBidUsecase) {
        this.placeBidUsecase = placeBidUsecase;
    }

    @Override
    public BidPlacementStatus placeBid(ItemBidCommand itemBidCommand) {
        //TODO mfguven : Here infrastructure -Adapter- is accessing core directly.
        return placeBidUsecase.placeBid(itemBidCommand);
    }


    @PostMapping(value = "/bid", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BidPlacementResponse> placeBidExpand(
            @RequestBody @Valid BidPlacementRequest bidPlacementRequest,
            @RequestHeader(value = "Correlation-Id", required = false) String correlationId)
    {
        BidPlacementStatus placeBidResult = placeBid(new ItemBidCommand(toBid(bidPlacementRequest), bidPlacementRequest.getItemId()));
        BidPlacementResponse response = new BidPlacementResponse(placeBidResult);
        return new ResponseEntity<>(response, toHttpStatus(placeBidResult));
    }

}
