package org.calinh.eurderbylinh.repository.orders;

import org.calinh.eurderbylinh.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class OrderRepository {
    private Map<UUID, Order> orders;

    public OrderRepository(OrderDataFactory orderDataFactory) {
        this.orders = orderDataFactory.getDefaultItems();
    }

    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

}
