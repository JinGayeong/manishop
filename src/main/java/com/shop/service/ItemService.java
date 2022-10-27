package com.shop.service;

import com.shop.domain.item.Item;
import com.shop.repository.ItemSearchCond;
import com.shop.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);

    void delte(Long itemId);

}