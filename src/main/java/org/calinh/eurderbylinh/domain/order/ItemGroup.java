package org.calinh.eurderbylinh.domain.order;

import org.calinh.eurderbylinh.domain.item.Item;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(Item item, int amount, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
