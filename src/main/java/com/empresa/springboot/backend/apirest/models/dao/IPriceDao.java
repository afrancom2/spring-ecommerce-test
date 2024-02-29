package com.empresa.springboot.backend.apirest.models.dao;

import com.empresa.springboot.backend.apirest.models.entity.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPriceDao extends CrudRepository<Price, Long> {

    @Query(value = "SELECT p FROM prices p " +
            "WHERE :priceDate >= p.startDate " +
            "AND :priceDate <=p.endDate " +
            "AND :productId = p.productId " +
            "ORDER BY p.priority DESC ")
    Optional<List<Price>> getPriceByDate(LocalDateTime priceDate, Integer productId);

}
