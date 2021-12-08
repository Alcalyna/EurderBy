package org.calinh.eurderbylinh.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.calinh.eurderbylinh.exception.exceptions.ItemInputIsNotValidException;

import java.util.UUID;

@JsonDeserialize(builder = Item.ItemBuilder.class)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
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
        if (price <= 0) {
            throw new ItemInputIsNotValidException("The price should be positive!");
        }
        if (amount <= 0) {
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

        public ItemBuilder withId(@JsonProperty("id") UUID id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withName(@JsonProperty("name")String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(@JsonProperty("description")String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(@JsonProperty("price") double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withAmount(@JsonProperty("amount") int amount) {
            this.amount = amount;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    public Item setName(String name) {
        if(!isEmpty(name)) {
            this.name = name;
        }
        return this;
    }

    public Item setDescription(String description) {
        if(!isEmpty(name)) {
            this.description = description;
        }
        return this;
    }

    public Item setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
        return this;
    }

    public Item setAmount(int amount) {
        if(price > 0) {
            this.amount = amount;
        }
        return this;
    }

    public boolean isEmpty(String message) {
        return message == null || message.trim().equals("");
    }

}
