package com.delivery.product.core.domain.entity.delivery;

import com.delivery.product.core.domain.data.delivery.CommandStatus;
import com.delivery.product.core.domain.data.delivery.DeliveryCommandType;
import com.delivery.product.core.domain.data.delivery.DeliveryMethod;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private UUID publicId = UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    private DeliveryCommandType commandType;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod method;

    private UUID productPublicId;
    private Float quantity;

    private Long parentId;
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private CommandStatus status;
}
