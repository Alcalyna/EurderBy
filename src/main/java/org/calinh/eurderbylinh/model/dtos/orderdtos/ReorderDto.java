package org.calinh.eurderbylinh.model.dtos.orderdtos;

import java.util.UUID;

public class ReorderDto {
    private UUID customerId;
    private UUID orderId;

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public ReorderDto setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }

    public ReorderDto setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }
}
