package com.empresa.springboot.backend.apirest.models.services;

import com.empresa.springboot.backend.apirest.models.dao.IPriceDao;
import com.empresa.springboot.backend.apirest.models.dto.PriceDto;
import com.empresa.springboot.backend.apirest.models.dto.PriceResponseDto;
import com.empresa.springboot.backend.apirest.models.entity.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceService implements IPriceService {

    private IPriceDao priceDao;

    @Override
    public Optional<Price> determineProduct(PriceDto priceDto) throws Exception {

        return priceDao.getPriceByDate(priceDto.getApplicationDate(), priceDto.getProductIdentifier())
                .map(pricesList -> pricesList.stream()
                        .filter(price -> price.getPriority().equals(
                                        pricesList.stream()
                                                .map(Price::getPriority)
                                                .max(Integer::compareTo).orElse(null)
                                )
                        )
                        .max(Comparator.comparing(Price::getPriority)))
                .orElseThrow(() -> new Exception(" Data not found "));
    }

    @Override
    public PriceResponseDto determineProductAndReturnString(PriceDto priceDto) throws Exception {

        Optional<Price> priceOptional = determineProduct(priceDto);

        Price priceFinal = priceOptional.orElseThrow(() -> new Exception(" Data not found "));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String hourFormatted = priceDto.getApplicationDate().format(formatter);

        return PriceResponseDto.builder()
                .productId(priceFinal.getProductId())
                .chain("request at " + hourFormatted + " on the " + priceDto.getApplicationDate().getDayOfMonth() + " for the product " + priceFinal.getProductId() + " for brand " + priceFinal.getBrandId())
                .priceFinal(priceFinal.getPrice())
                .dateApplicable(priceDto.getApplicationDate())
                .build();
    }

}
