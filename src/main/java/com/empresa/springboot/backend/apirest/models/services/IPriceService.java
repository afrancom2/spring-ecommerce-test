package com.empresa.springboot.backend.apirest.models.services;

import com.empresa.springboot.backend.apirest.models.dto.PriceDto;
import com.empresa.springboot.backend.apirest.models.dto.PriceResponseDto;
import com.empresa.springboot.backend.apirest.models.entity.Price;

import java.util.Optional;

public interface IPriceService {

    Optional<Price> determineProduct(PriceDto priceDto) throws Exception;
    PriceResponseDto determineProductAndReturnString(PriceDto priceDto) throws Exception;

}