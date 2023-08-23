package com.bidbinding.auction.engine.application.core.usecase;

import com.bidbinding.auction.engine.application.core.model.bid.Bid;
import com.bidbinding.auction.engine.application.core.model.bid.BidPlacementStatus;
import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import com.bidbinding.auction.engine.application.port.driven.EventPort;
import com.bidbinding.auction.engine.application.port.driven.FraudDetectionPort;
import com.bidbinding.auction.engine.application.port.driven.ItemPort;
import com.bidbinding.auction.engine.application.port.driven.TenancyPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ForwardAuctionUseCase {

    private EventPort eventPort;
    private FraudDetectionPort fraudDetectionPort;
    private ItemPort<ForwardAuctionItem> itemPort;
    private TenancyPort tenancyPort;

    public BidPlacementStatus placeBid(Bid bid, String onItem) {

//        Optional<FraudDetectionResult> fraudProbability = fraudDetectionPort.checkFraudProbability(new ItemBidCommand(bid, onItem));
//        fraudProbability.ifPresent(bid::markAsFraud);
        ForwardAuctionItem item = itemPort.getItem(onItem);
        BidPlacementStatus bidPlacementStatus = item.recordBid(bid);
        item.storeForTenant(tenancyPort.getTenant());

        itemPort.updateItem(item);
        eventPort.bidPlaced(bid);

        return bidPlacementStatus;

    }

}
