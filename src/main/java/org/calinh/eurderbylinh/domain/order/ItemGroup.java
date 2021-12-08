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

    public Item getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroup setItem(Item item) {
        this.item = item;
        return this;
    }

    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
