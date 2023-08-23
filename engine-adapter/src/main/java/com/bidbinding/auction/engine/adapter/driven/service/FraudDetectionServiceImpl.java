package com.bidbinding.auction.engine.adapter.driven.service;

import com.bidbinding.auction.engine.adapter.driven.dto.BidFraudDto;
import com.bidbinding.auction.engine.application.core.model.fraud.FraudDetectionResult;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Override
    public FraudDetectionResult detectFraud(BidFraudDto bid) {
        return null;
    }
}
