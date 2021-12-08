package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.model.dtos.orderdtos.CreateOrderDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.OrderDto;
import org.calinh.eurderbylinh.model.services.OrderService;
import org.calinh.eurderbylinh.model.services.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="orders")
public class OrderController {

    private OrderService orderService;
    private SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody CreateOrderDto newOrder, @RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.ADD_ORDER);
        User currentUser = securityService.getCurrentUser(authorization);
        newOrder.setUserId(currentUser.getId());
//        securityService.isCorrectUser(currentUser.getId(), newOrder.getUserId());
        return orderService.addOrder(newOrder);
    }
}
