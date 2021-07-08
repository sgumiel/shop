package com.sgumiel.shop.infrastructure.rest.factory;

import com.sgumiel.shop.domain.exception.PriceException;
import com.sgumiel.shop.infrastructure.rest.model.ApiErrorResponse;

public interface ApiErrorResponseFactory {

  ApiErrorResponse createApiErrorResponse(PriceException priceException);
}
