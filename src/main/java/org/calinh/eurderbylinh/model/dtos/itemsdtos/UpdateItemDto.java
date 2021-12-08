package org.calinh.eurderbylinh.model.dtos.itemsdtos;

import java.util.UUID;

public class UpdateItemDto {
    private UUID itemId;
    private String name;
    private String description;
    private double price;
    private int amount;

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public UpdateItemDto setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public UpdateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public UpdateItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "UpdateItemDto{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
