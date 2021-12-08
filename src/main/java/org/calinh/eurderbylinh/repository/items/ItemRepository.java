package org.calinh.eurderbylinh.repository.items;

import org.calinh.eurderbylinh.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemRepository {
    private Map<UUID, Item> items;

    public ItemRepository(ItemDataFactory itemDataFactory) {
        this.items = itemDataFactory.getDefaultItems();
    }

    public Item save(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public Item getById(UUID id) {
        return items.get(id);
    }

    public int getAmoutById(UUID id) {
        return this.getById(id).getAmount();
    }

    public List<Item> getAllItems() {
        return this.items.values().stream().collect(Collectors.toList());
    }
}
