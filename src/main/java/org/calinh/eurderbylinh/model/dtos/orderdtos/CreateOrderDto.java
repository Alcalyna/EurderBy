package org.calinh.eurderbylinh.model.dtos.orderdtos;

import java.util.List;
import java.util.UUID;

public class CreateOrderDto {

    private UUID userId;
    private List<ItemGroupDto> itemGroupList;

    public UUID getUserId() {
        return userId;
    }

    public List<ItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }

    public CreateOrderDto setItemGroupList(List<ItemGroupDto> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public CreateOrderDto setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }
}
