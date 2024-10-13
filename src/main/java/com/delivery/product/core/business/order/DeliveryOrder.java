package com.delivery.product.core.business.order;

import com.delivery.product.core.domain.data.delivery.CommandStatus;
import com.delivery.product.core.domain.data.delivery.DeliveryCommandType;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import com.delivery.product.core.port.in.delivery.IDeliveryOrder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeliveryOrder implements IDeliveryOrder {

    private final Map<DeliveryCommandType, SubCommandProcessor> subCommandProcessorMap = new HashMap<>();

    @Autowired
    private List<SubCommandProcessor> subCommandProcessors;

    @PostConstruct
    public void initProcessing() {
        subCommandProcessors.forEach(processor -> subCommandProcessorMap.put(processor.getType(), processor));
    }

    @Override
    public void order(List<Delivery> deliveries) {
        deliveries.forEach(delivery -> {
            SubCommandProcessor processor = subCommandProcessorMap.get(delivery.getCommandType());
            delivery.setStatus(CommandStatus.IN_PROGRESS);
            processor.process(delivery);
        });
    }
}

