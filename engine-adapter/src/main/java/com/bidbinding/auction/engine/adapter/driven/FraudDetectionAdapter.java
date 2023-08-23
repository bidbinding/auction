package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.adapter.driven.dto.BidFraudAdaptor;
import com.bidbinding.auction.engine.adapter.driven.dto.BidFraudDto;
import com.bidbinding.auction.engine.adapter.driven.service.FraudDetectionService;
import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.ItemBidCommand;
import com.bidbinding.auction.engine.application.core.model.fraud.FraudDetectionResult;
import com.bidbinding.auction.engine.application.port.driven.FraudDetectionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FraudDetectionAdapter implements FraudDetectionPort {
    @Autowired
    private FraudDetectionService fraudDetectionService;

    @Override
    public Optional<FraudDetectionResult> checkFraudProbability(ItemBidCommand itemBidCommand) {
        BidFraudDto bidToDetectFraud = BidFraudAdaptor.dtoFrom(itemBidCommand.bid());
        bidToDetectFraud.setOnItemId(itemBidCommand.onItemId());
        FraudDetectionResult fraudDetectionResult = fraudDetectionService.detectFraud(bidToDetectFraud);
        if (fraudDetectionResult == null) {
            return Optional.empty();
        }
        return Optional.of(fraudDetectionResult);
    }

    @Override
    public void reportSuspectedFraud(String itemId, Bid bid, List<FraudDetectionResult> fraudDetectionResults) {

    }

}
