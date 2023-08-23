package com.bidbinding.auction.engine.application.port.driven;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.ItemBidCommand;
import com.bidbinding.auction.engine.application.core.model.fraud.FraudDetectionResult;

import java.util.List;
import java.util.Optional;


public interface FraudDetectionPort {

    Optional<FraudDetectionResult> checkFraudProbability(ItemBidCommand itemBidCommand);

    void reportSuspectedFraud(String itemId, Bid bid, List<FraudDetectionResult> fraudDetectionResults);

}
