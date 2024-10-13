package com.delivery.product.core.business.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@RequiredArgsConstructor
@Slf4j
@Service
public class DeliveryQueueManager {

    private final BlockingQueue<UUID> deliveryReadQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<DeliveryRequest> deliveryWriteQueue = new LinkedBlockingQueue<>();

}
