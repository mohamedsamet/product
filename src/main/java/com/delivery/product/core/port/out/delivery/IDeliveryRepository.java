package com.delivery.product.core.port.out.delivery;

import com.delivery.product.core.domain.entity.delivery.Delivery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDeliveryRepository {

    List<Delivery> saveAll(List<Delivery> deliveryList);
    Optional<Delivery> findByPublicId(UUID deliveryPublicId);

    List<Delivery> findAvailableDeliveries();
}
