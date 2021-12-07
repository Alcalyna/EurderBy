package org.calinh.eurderbylinh.repository.items;

import org.calinh.eurderbylinh.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemDataFactory {
    public Map<String, Item> getDefaultItems() {
        Item item0 = new Item("Pulco Orange", "Better than the lemon one", 5.51, 5);

        Map<String, Item> result = new HashMap<>();
        result.put(item0.getName(), item0);
        return result;
    }
}
