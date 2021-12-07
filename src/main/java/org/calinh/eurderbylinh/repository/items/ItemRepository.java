package org.calinh.eurderbylinh.repository.items;

import org.calinh.eurderbylinh.domain.user.Item;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ItemRepository {
    private Map<String, Item> items;

    public ItemRepository(ItemDataFactory itemDataFactory) {
        this.items = itemDataFactory.getDefaultItems();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public Item save(Item item) {
        this.getItems().put(item.getName(), item);
        return item;
    }
}
