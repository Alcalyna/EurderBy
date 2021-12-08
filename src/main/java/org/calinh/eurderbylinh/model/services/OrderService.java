package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.item.Item;
import org.calinh.eurderbylinh.domain.order.ItemGroup;
import org.calinh.eurderbylinh.domain.order.Order;
import org.calinh.eurderbylinh.model.dtos.orderdtos.CreateOrderDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.ItemGroupDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.OrderDto;
import org.calinh.eurderbylinh.model.mappers.OrderMapper;
import org.calinh.eurderbylinh.repository.items.ItemRepository;
import org.calinh.eurderbylinh.repository.orders.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemRepository = itemRepository;
    }

    private LocalDate getShippingDate(ItemGroupDto itemGroupDto) {
        LocalDate shippingDate = LocalDate.now().plusDays(1);
        if (itemRepository.getAmoutById(itemGroupDto.getItemId()) < itemGroupDto.getAmount()) {
            shippingDate = LocalDate.now().plusDays(6);
        }
        return shippingDate;
    }


    private List<ItemGroup> toItemGroup(List<ItemGroupDto> itemsGroupDto) {
        List<ItemGroup> itemsGroup = new ArrayList<>();
        for(Item item: itemRepository.getAllItems()){
        }
        for (ItemGroupDto itemGroupDto : itemsGroupDto) {
            Item item = itemRepository.getById(itemGroupDto.getItemId());
            Item copyItem = new Item(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
            LocalDate shippingDate = getShippingDate(itemGroupDto);
            ItemGroup itemGroup = new ItemGroup(copyItem, itemGroupDto.getAmount(), shippingDate);
            itemsGroup.add(itemGroup);
        }
        return itemsGroup;
    }

    public OrderDto addOrder(CreateOrderDto createOrderDto) {
        List<ItemGroup> itemsGroup = toItemGroup(createOrderDto.getItemGroupList());
        Order order = new Order(createOrderDto.getUserId(), itemsGroup);
        orderRepository.save(order);
        OrderDto orderDto = orderMapper.mapOrderToOrderDto(order);
        return orderMapper.mapOrderToOrderDto(order);
    }

    public List<OrderDto> getOrdersByCustomerId(UUID customerId) {
        return orderRepository.getAllOrdersByCustomerId(customerId).stream()
                .map(order -> orderMapper.mapOrderToOrderDto(order))
                .collect(Collectors.toList());
    }
}
