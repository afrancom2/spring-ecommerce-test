package com.empresa.springboot.backend.apirest.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "prices")
@ToString
public class Price implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand_id")
	private Long brandId;

	@Column(nullable = false, name = "start_date")
	private LocalDateTime startDate;

	@Column(nullable = false, name = "end_date")
	private LocalDateTime endDate;

	@Column(nullable = false, name = "price_list")
	private String priceList;

	@Column(name = "product_id")
	private Integer productId;

	private Integer priority;

	private Float price;

	private String Curr;

}
