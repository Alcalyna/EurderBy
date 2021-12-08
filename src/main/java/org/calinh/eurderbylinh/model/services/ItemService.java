package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.item.Item;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.UpdateItemDto;
import org.calinh.eurderbylinh.model.mappers.ItemMapper;
import org.calinh.eurderbylinh.repository.items.ItemDataFactory;
import org.calinh.eurderbylinh.repository.items.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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

    public List<ItemDto> getAllItemsReposository() {
        return itemRepository.getAllItems().stream()
                .map(item -> itemMapper.mapItemToItemDto(item))
                .collect(Collectors.toList());
    }

    public ItemDto updateItem(UpdateItemDto updateItemDto) {
        Item item = itemRepository.getById(updateItemDto.getItemId());
        item.setName(updateItemDto.getName());
        item.setDescription(updateItemDto.getDescription());
        item.setPrice(updateItemDto.getPrice());
        item.setAmount(updateItemDto.getAmount());
        itemRepository.save(item);
        return itemMapper.mapItemToItemDto(item);
    }
}
