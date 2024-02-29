package com.empresa.springboot.backend.apirest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceResponseDto {
    private Integer productId;
    private String chain;
    private LocalDateTime dateApplicable;
    private float priceFinal;
}
