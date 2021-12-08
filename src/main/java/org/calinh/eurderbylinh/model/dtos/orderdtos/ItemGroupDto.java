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

}
