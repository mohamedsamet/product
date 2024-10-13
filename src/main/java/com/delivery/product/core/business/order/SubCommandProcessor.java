package com.delivery.product.core.business.order;

import com.delivery.product.core.domain.data.delivery.DeliveryCommandType;
import com.delivery.product.core.domain.entity.delivery.Delivery;

public interface SubCommandProcessor {

    void process(Delivery delivery);

    DeliveryCommandType getType();
}
