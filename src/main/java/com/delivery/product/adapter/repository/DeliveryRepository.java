package com.delivery.product.adapter.repository;

import com.delivery.product.adapter.repository.jpa.DeliveryJpaRepository;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import com.delivery.product.core.port.out.delivery.IDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository implements IDeliveryRepository {

    private final DeliveryJpaRepository deliveryJpaRepository;

    @Override
    public List<Delivery> saveAll(List<Delivery> deliveryList) {
        return deliveryJpaRepository.saveAll(deliveryList);
    }
}
