package com.sgumiel.shop.application;

import java.util.Optional;

import com.sgumiel.shop.domain.Price;
import com.sgumiel.shop.domain.filter.PriceFilter;

public interface PriceService {

  Optional<Price> findByFilter(PriceFilter priceFilter);
}
