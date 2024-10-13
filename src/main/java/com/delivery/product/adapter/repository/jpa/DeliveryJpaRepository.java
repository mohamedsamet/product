package com.delivery.product.adapter.repository.jpa;

import com.delivery.product.core.domain.entity.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<Delivery, Long> {
}
