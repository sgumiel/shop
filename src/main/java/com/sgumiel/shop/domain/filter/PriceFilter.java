package com.sgumiel.shop.domain.filter;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class PriceFilter {

  private LocalDateTime date;
  private Integer productId;
  private Integer brandId;
}
