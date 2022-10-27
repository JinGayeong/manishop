package com.shop.service;

import com.shop.domain.item.Item;
import com.shop.repository.ItemSearchCond;
import com.shop.repository.ItemUpdateDto;
import com.shop.repository.v2.ItemQueryRepositoryV2;
import com.shop.repository.v2.ItemRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceV2 implements ItemService {

    private final ItemRepositoryV2 itemRepositoryV2;
    private final ItemQueryRepositoryV2 itemQueryRepositoryV2;

    @Override
    public Item save(Item item) {
        return itemRepositoryV2.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = itemRepositoryV2.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepositoryV2.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemQueryRepositoryV2.findAll(cond);
    }

    @Override
    public void delte(Long itemId) {
        Item item = itemRepositoryV2.findById(itemId).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+itemId));
        itemRepositoryV2.delete(item);
    }

}
