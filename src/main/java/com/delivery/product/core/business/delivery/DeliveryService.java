package com.delivery.product.core.business.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import com.delivery.product.core.port.in.delivery.IDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryService implements IDeliveryService {

    private final IDeliveryProcessingService deliveryProcessingService;
    private final DeliveryScheduler deliveryScheduler;

    @Override
    public void process(DeliveryRequest deliveryRequest) {
        try {
            deliveryScheduler.getDeliveryQueue().put(deliveryRequest);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            log.error("Interruption Exception When trying to add Delivery Request To The queue", exception);
        }
    }

    @Scheduled(fixedRate = 50)
    public void processQueue() {
        while (!deliveryScheduler.getDeliveryQueue().isEmpty()) {
            try {
                DeliveryRequest request = deliveryScheduler.getDeliveryQueue().poll();
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
