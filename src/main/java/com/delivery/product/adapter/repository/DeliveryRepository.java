package com.delivery.product.adapter.repository;

import com.delivery.product.adapter.repository.jpa.DeliveryJpaRepository;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import com.delivery.product.core.port.out.delivery.IDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository implements IDeliveryRepository {

    private final DeliveryJpaRepository deliveryJpaRepository;

    @Override
    public List<Delivery> saveAll(List<Delivery> deliveryList) {
        return deliveryJpaRepository.saveAll(deliveryList);
    }

    @Override
    public Optional<Delivery> findByPublicId(UUID deliveryPublicId) {
        return deliveryJpaRepository.findByPublicId(deliveryPublicId);
    }

    @Override
    public List<Delivery> findAvailableDeliveries() {
        return deliveryJpaRepository.findAvailableDeliveries();
    }
}
