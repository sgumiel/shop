package com.sgumiel.shop.domain.repository;

import java.util.List;

import com.sgumiel.shop.domain.Price;
import com.sgumiel.shop.domain.filter.PriceFilter;

public interface PriceRepository {

  List<Price> findByFilter(PriceFilter priceFilter);
}
