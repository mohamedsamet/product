package com.delivery.product.core.business.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import com.delivery.product.core.port.in.delivery.IDeliveryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryScheduler {

    private final IDeliveryProcessingService deliveryProcessingService;
    @Getter
    private final BlockingQueue<DeliveryRequest> deliveryQueue = new LinkedBlockingQueue<>();


    @Scheduled(fixedRate = 50)
    public void processQueue() {
        while (!deliveryQueue.isEmpty()) {
            try {
                DeliveryRequest request = deliveryQueue.poll();
                if (request != null) {
                    deliveryProcessingService.processDelivery(request);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                log.error("Interruption Exception When trying to Process Delivery Request ", e);
            }
        }
    }
}
