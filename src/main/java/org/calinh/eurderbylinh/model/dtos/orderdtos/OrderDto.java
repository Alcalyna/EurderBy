package org.calinh.eurderbylinh.model.dtos.orderdtos;

import org.calinh.eurderbylinh.domain.order.ItemGroup;

import java.util.List;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    private UUID customerId;
    private List<ItemGroup> itemGroupList;
    private double total;

    public OrderDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public OrderDto setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setItemGroupList(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public OrderDto setTotal(double total) {
        this.total = total;
        return this;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public double getTotal() {
        return total;
    }
}
