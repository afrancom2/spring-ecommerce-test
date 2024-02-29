package com.empresa.springboot.backend.apirest.controllers;

import com.empresa.springboot.backend.apirest.models.dto.PriceDto;
import com.empresa.springboot.backend.apirest.models.dto.PriceResponseDto;
import com.empresa.springboot.backend.apirest.models.entity.Price;
import com.empresa.springboot.backend.apirest.models.services.IPriceService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PriceRestController {

    private IPriceService priceService;

    @GetMapping("/price")
    public Optional<Price> price(@Validated @RequestBody PriceDto priceDto) throws Exception {
        return priceService.determineProduct(priceDto);
    }

    @GetMapping("/priceString")
    public PriceResponseDto priceString(@Validated @RequestBody PriceDto priceDto) throws Exception {
        return priceService.determineProductAndReturnString(priceDto);
    }

}
