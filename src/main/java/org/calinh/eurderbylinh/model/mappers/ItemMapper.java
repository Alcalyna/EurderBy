package org.calinh.eurderbylinh.model.mappers;

import org.calinh.eurderbylinh.domain.user.Item;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto()
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setAmount(item.getAmount());
    }

    public Item mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmount());
    }
}