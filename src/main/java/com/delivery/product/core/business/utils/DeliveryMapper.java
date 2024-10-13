package com.delivery.product.core.business.utils;

import com.delivery.product.core.domain.data.delivery.CommandStatus;
import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.domain.data.delivery.ProductDeliveryRequest;
import com.delivery.product.core.domain.entity.delivery.Delivery;

import java.time.LocalDateTime;
import java.util.UUID;

public final class DeliveryMapper {

    public static Delivery toDeliveryParent(DeliveryRequest request) {
        return Delivery.builder()
                .commandType(request.getCommandType())
                .method(request.getMethod())
                .status(CommandStatus.PENDING)
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static Delivery toDeliverySlice(ProductDeliveryRequest productDeliveryRequest, Delivery parent) {
        return Delivery.builder()
                .commandType(parent.getCommandType())
                .method(parent.getMethod())
                .parentId(parent.getId())
                .productPublicId(productDeliveryRequest.getProductPublicId())
                .quantity(productDeliveryRequest.getQuantity())
                .status(CommandStatus.PENDING)
                .creationDate(LocalDateTime.now())
                .build();
    }

}
