package com.delivery.product.core.business.order.subcommands;

import com.delivery.product.core.business.order.SubCommandProcessor;
import com.delivery.product.core.domain.data.delivery.DeliveryCommandType;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ManualOperationOrderSerivce implements SubCommandProcessor {

    @Override
    public void process(Delivery delivery) {
        log.info("manual operation");
    }

    @Override
    public DeliveryCommandType getType() {
        return DeliveryCommandType.MANUAL;
    }
}
