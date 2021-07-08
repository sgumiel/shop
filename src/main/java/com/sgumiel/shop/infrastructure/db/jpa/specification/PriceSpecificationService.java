package com.sgumiel.shop.infrastructure.db.jpa.specification;

import com.sgumiel.shop.domain.filter.PriceFilter;
import com.sgumiel.shop.infrastructure.db.model.PriceEntity;
import org.springframework.data.jpa.domain.Specification;

public interface PriceSpecificationService {

  Specification<PriceEntity> createDefaultSpecification(PriceFilter priceFilter);
}