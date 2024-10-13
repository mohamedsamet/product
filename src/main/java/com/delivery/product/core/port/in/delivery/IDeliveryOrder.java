package com.delivery.product.core.port.in.delivery;

import com.delivery.product.core.domain.entity.delivery.Delivery;

import java.util.List;

public interface IDeliveryOrder {
    void order(List<Delivery> delivery);
}
