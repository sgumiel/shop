package com.sgumiel.shop.domain.exception;

import com.sgumiel.shop.domain.enums.PriceError;
import lombok.Getter;

@Getter
public class PriceException extends RuntimeException {

  private PriceError error;

  public PriceException(PriceError error){
    this.error = error;
  }
}