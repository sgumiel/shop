package com.sgumiel.shop.infrastructure.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sgumiel.shop.infrastructure.rest.function.FieldErrorToApiErrorResponseMapper;
import com.sgumiel.shop.infrastructure.rest.model.ApiErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class PricesExceptionController {

  private final FieldErrorToApiErrorResponseMapper fieldErrorToApiErrorResponseMapper;

  @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
  public ResponseEntity<List<ApiErrorResponse>> handlePriceException(BindException exception) {
    log.debug("Handle for exception: {}", exception);

    final var errorList =  exception.getBindingResult().getAllErrors();

    final var apiErrorList = errorList.stream()
            .map( objectError -> (FieldError)objectError)
            .map( fieldError -> this.fieldErrorToApiErrorResponseMapper.apply(fieldError))
            .collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorList);

  }
}
