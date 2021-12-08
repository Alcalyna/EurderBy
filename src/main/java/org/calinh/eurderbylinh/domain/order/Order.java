package org.calinh.eurderbylinh.domain.order;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final UUID customerId;
    private final List<ItemGroup> itemGroupList;
    private double total;

    public Order(UUID customerId, List<ItemGroup> itemGroupList) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.itemGroupList = itemGroupList;
        this.total = computeTotal(itemGroupList);
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public double computeTotal(List<ItemGroup> itemsGroup) {
        double price = 0;
        for (ItemGroup itemGroup: itemsGroup) {
            price += itemGroup.getAmount() * itemGroup.getItem().getPrice();
        }
        return Math.round(price * 100.0)/100.0;
    }

    public double getTotal() {
        return total;
    }
}
