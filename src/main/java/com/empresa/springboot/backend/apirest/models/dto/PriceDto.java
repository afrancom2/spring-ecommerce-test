package com.empresa.springboot.backend.apirest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceDto {
    private LocalDateTime applicationDate;
    private Integer productIdentifier;
}
