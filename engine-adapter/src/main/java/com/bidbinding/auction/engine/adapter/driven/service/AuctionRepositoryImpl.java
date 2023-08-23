package com.bidbinding.auction.engine.adapter.driven.service;

import com.bidbinding.auction.engine.adapter.common.DataAccessAdapter;
import com.bidbinding.auction.engine.adapter.driven.dto.ItemAdaptor;
import com.bidbinding.auction.engine.adapter.driven.dto.ItemDto;
import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import lombok.AllArgsConstructor;

@DataAccessAdapter
@AllArgsConstructor
public class AuctionRepositoryImpl implements AuctionRepository {

    private final ItemRepository itemRepository;
    private final BidRepository bidRepository;

    public ForwardAuctionItem getForwardAuctionItem(String itemId) {
//        Optional<> itemForward = itemRepository.getItemByItemId(itemId);
//        ForwardAuctionItem item = ItemAdaptor.toForward(itemForward);
//        List<Bid> bids = bidRepository.getBidsForItem(itemForward.getId());
//        item.setBids(BidAdapter.adapt(bids));
        return null;
    }

    @Override
    public void updateForwardItem(ForwardAuctionItem item) {
        System.out.println("Update item in repository");
        ItemDto itemDto = ItemAdaptor.from(item);
        //auctionJpaService.updateItem(itemDto);
    }

}
