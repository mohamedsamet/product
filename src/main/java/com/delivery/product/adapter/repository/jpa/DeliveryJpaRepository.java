package com.delivery.product.adapter.repository.jpa;

import com.delivery.product.core.domain.entity.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryJpaRepository extends JpaRepository<Delivery, Long> {

    Optional<Delivery> findByPublicId(UUID publicId);

    @Query(" SELECT dl FROM Delivery dl WHERE dl.status = PENDING AND dl.parentId is null")
    List<Delivery> findAvailableDeliveries();
}
