package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.item.Item;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.calinh.eurderbylinh.model.mappers.ItemMapper;
import org.calinh.eurderbylinh.repository.items.ItemDataFactory;
import org.calinh.eurderbylinh.repository.items.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    ItemRepository itemRepository;
    ItemDataFactory itemDataFactory;
    ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemDataFactory itemDataFactory, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemDataFactory = itemDataFactory;
        this.itemMapper = itemMapper;
    }

    public ItemDto addItem(CreateItemDto newItem) {
        Item item = itemMapper.mapCreateItemDtoToItem(newItem);
        itemRepository.save(item);
        return itemMapper.mapItemToItemDto(item);
    }
}
