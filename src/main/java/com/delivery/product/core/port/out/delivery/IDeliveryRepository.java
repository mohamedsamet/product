package com.delivery.product.core.port.out.delivery;

import com.delivery.product.core.domain.entity.delivery.Delivery;

import java.util.List;

public interface IDeliveryRepository {

    List<Delivery> saveAll(List<Delivery> deliveryList);
}
