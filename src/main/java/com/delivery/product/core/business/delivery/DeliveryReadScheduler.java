package com.delivery.product.core.business.delivery;

import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryReadScheduler {

    private final IDeliveryProcessingService deliveryProcessingService;

    /* Throughput to handle available pending deliveries  */
    // TODO Optimize the rate according to performace indicators
    @Scheduled(fixedRateString = "${app.delivery.read.rate}")
    public void processQueue() {
        deliveryProcessingService.processDeliveryToOrders();
    }
}
