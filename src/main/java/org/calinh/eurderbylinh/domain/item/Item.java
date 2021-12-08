package org.calinh.eurderbylinh.domain.item;

import org.calinh.eurderbylinh.exception.exceptions.ItemInputIsNotValidException;

import java.util.UUID;

public class Item {
    private final UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        isValidInputs(name, description, price, amount);
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(UUID id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.id;
        this.name = itemBuilder.name;
        this.description = itemBuilder.description;
        this.price = itemBuilder.price;
        this.amount = itemBuilder.amount;
    }

    private void isValidInputs(String name, String description, double price, int amount) {
        if (name == null || name.trim().equals("")) {
            throw new ItemInputIsNotValidException("The item's name should be provided!");
        }
        if (description == null || description.trim().equals("")) {
            throw new ItemInputIsNotValidException("The item's description should be provided!");
        }
        if (price < 0) {
            throw new ItemInputIsNotValidException("The price should be positive!");
        }
        if (amount < 0) {
            throw new ItemInputIsNotValidException("The amount should be a positive integer!");
        }
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

    public static final class ItemBuilder {
        private UUID id;
        private String name;
        private String description;
        private double price;
        private int amount;

        private ItemBuilder() {
        }

        public static ItemBuilder itemBuilder() {
            return new ItemBuilder();
        }

        public ItemBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
