package org.calinh.eurderbylinh.repository.items;

import org.calinh.eurderbylinh.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ItemDataFactory {
    public Map<UUID, Item> getDefaultItems() {
        Map<UUID, Item> result = new HashMap<>();

        Item item0 = new Item(UUID.fromString("5080b865-7d04-4aa6-b34a-89c3318072d3"),"Pulco Orange", "Better than the lemon one", 5.51, 5);
        result.put(item0.getId(), item0);

        Item item1 = new Item(UUID.fromString("256c95a4-a43b-42aa-8f53-e2dbf4849855"),"Fried noodles", "Asian cuisine", 10.60, 1);
        result.put(item1.getId(), item1);

        Item item2 = new Item(UUID.fromString("0e3a2883-eca0-4127-aef7-28c6a4a7fd39"),"Apple", "Mac", 1000, 10);
        result.put(item2.getId(), item2);
        return result;
    }
}
