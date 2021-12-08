package org.calinh.eurderbylinh.model.mappers;

import org.calinh.eurderbylinh.domain.order.Order;
import org.calinh.eurderbylinh.model.dtos.orderdtos.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto mapOrderToOrderDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setCustomerId(order.getCustomerId())
                .setItemGroupList(order.getItemGroupList())
                .setTotal(order.getTotal());
    }
}
