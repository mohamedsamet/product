package com.delivery.product.core.business.order.subcommands;

import com.delivery.product.core.business.order.SubCommandProcessor;
import com.delivery.product.core.domain.data.delivery.DeliveryCommandType;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternWarehouseOrderSerivce implements SubCommandProcessor {

    @Override
    public void process(Delivery delivery) {
        log.info("interne Warehouse");

        // TODO Logic to create order to deliver and update product inventory for the case INT_WAREHOUSE
    }

    @Override
    public DeliveryCommandType getType() {
        return DeliveryCommandType.INT_WAREHOUSE;
    }
}
