package org.calinh.eurderbylinh.domain.item;

import org.calinh.eurderbylinh.domain.item.Item;
import org.calinh.eurderbylinh.exception.exceptions.ItemInputIsNotValidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class ItemTest {
    Item item;

    @BeforeEach
    void init() {
        item = new Item( "Pulco", "Orange", 5.51, 5);
    }

    @Test
    void getName() {
        Assertions.assertEquals("Pulco", item.getName());
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Orange", item.getDescription());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(5.51, item.getPrice(), 0.01);
    }

    @Test
    void getAmount() {
        Assertions.assertEquals(5, item.getAmount());
    }

    @Test
    void givenEmptyInput_ThrowError() {
        Throwable exception = catchThrowable(() -> new Item( "Pulco", "", 5.51,5));

        Assertions.assertEquals(exception.getClass(), ItemInputIsNotValidException.class);
        Assertions.assertEquals("The item's description should be provided!",exception.getMessage());
    }
}