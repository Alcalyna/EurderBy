package org.calinh.eurderbylinh.model.dtos.itemsdtos;

import java.util.UUID;

public class ItemDto {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public ItemDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
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

    public UUID getId() {
        return id;
    }
}
