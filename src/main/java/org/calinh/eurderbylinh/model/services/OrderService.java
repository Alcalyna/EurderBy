package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.item.Item;
import org.calinh.eurderbylinh.domain.order.ItemGroup;
import org.calinh.eurderbylinh.domain.order.Order;
import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.model.dtos.orderdtos.CreateOrderDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.ItemGroupDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.OrderDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.ReorderDto;
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
    SecurityService securityService;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ItemRepository itemRepository, SecurityService securityService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemRepository = itemRepository;
        this.securityService = securityService;
    }

    private LocalDate getShippingDate(ItemGroupDto itemGroupDto) {
        LocalDate shippingDate = LocalDate.now().plusDays(1);
        if (itemRepository.getAmoutById(itemGroupDto.getItemId()) < itemGroupDto.getAmount()) {
            shippingDate = LocalDate.now().plusDays(6);
        }
        return shippingDate;
    }

    private LocalDate getShippingDate(ItemGroup itemGroup) {
        LocalDate shippingDate = LocalDate.now().plusDays(1);
        if (itemRepository.getAmoutById(itemGroup.getItem().getId()) < itemGroup.getAmount()) {
            shippingDate = LocalDate.now().plusDays(6);
        }
        return shippingDate;
    }

    private List<ItemGroup> toItemGroup(List<ItemGroupDto> itemsGroupDto) {
        List<ItemGroup> itemsGroup = new ArrayList<>();
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
        return orderMapper.mapOrderToOrderDto(order);
    }

    public List<OrderDto> getOrdersByCustomerId(UUID customerId) {
        return orderRepository.getAllOrdersByCustomerId(customerId).stream()
                .map(order -> orderMapper.mapOrderToOrderDto(order))
                .collect(Collectors.toList());
    }

    public boolean setUserToReorder(ReorderDto reorderDto, User user) {
        return orderRepository.matchOrderCustomer(user.getId());
    }

    private List<ItemGroup> itemGroupFromReorderDto(ReorderDto reorderDto, User user) {
        setUserToReorder(reorderDto, user);
        List<ItemGroup> result = new ArrayList<>();
        Order order = orderRepository.getById(reorderDto.getOrderId());
        for(ItemGroup itemGroup: order.getItemGroupList()) {
            Item item = itemRepository.getById(itemGroup.getItem().getId());
            Item copyItem = new Item(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
            ItemGroup newItemGroup = new ItemGroup(copyItem, itemGroup.getAmount()).setShippingDate(getShippingDate(itemGroup));
            result.add(newItemGroup);
        }
        return result;
    }

    public OrderDto orderAgain(ReorderDto reorderDto, User user) {
        Order order = new Order(user.getId(), itemGroupFromReorderDto(reorderDto, user));
        orderRepository.save(order);
        return orderMapper.mapOrderToOrderDto(order);
    }
}
