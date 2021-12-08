package org.calinh.eurderbylinh.model.dtos.orderdtos;

import java.util.UUID;

public class ItemGroupDto {
    private UUID itemId;
    private int amount;

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public ItemGroupDto setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
