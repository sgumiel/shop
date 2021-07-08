package com.sgumiel.shop.infrastructure.rest.map;

import com.sgumiel.shop.domain.Price;
import com.sgumiel.shop.domain.filter.PriceFilter;
import com.sgumiel.shop.infrastructure.rest.model.PriceResponse;
import com.sgumiel.shop.infrastructure.rest.model.PricesRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceRestMapper {

  PriceFilter toDomain(PricesRequest source);

  PriceResponse toResponse(Price source);
}
