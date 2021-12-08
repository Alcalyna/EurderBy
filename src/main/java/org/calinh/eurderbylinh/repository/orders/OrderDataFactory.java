package org.calinh.eurderbylinh.repository.orders;

import org.calinh.eurderbylinh.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderDataFactory {
    public Map<UUID, Order> getDefaultItems() {
        Map<UUID, Order> result = new HashMap<>();
        return result;
    }
}
