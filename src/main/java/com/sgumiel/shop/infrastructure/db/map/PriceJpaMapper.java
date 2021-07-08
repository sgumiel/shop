package com.sgumiel.shop.infrastructure.db.map;

import java.util.List;

import com.sgumiel.shop.domain.Price;
import com.sgumiel.shop.infrastructure.db.model.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceJpaMapper {

  Price toDomain(PriceEntity source);

  List<Price> toDomain(List<PriceEntity> source);
}
