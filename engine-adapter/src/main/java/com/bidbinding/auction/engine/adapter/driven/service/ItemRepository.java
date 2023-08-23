package com.bidbinding.auction.engine.adapter.driven.service;

import com.bidbinding.auction.engine.adapter.driven.dto.ItemForwardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<ItemForwardEntity, Long> {

    @Query(value = "select a from item_forward a where a.item_id = :itemId")
    Optional<ItemForwardEntity> getItemByItemId(
            @Param("itemId") String itemId);

}
