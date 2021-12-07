package org.calinh.eurderbylinh.domain.item;

import org.calinh.eurderbylinh.exception.exceptions.ItemInputIsNotValidException;

import java.util.UUID;

public class Item {
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        isValidInputs(name, description, price, amount);
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

}
