package com.sgumiel.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgumiel.shop.domain.enums.PriceError;
import com.sgumiel.shop.infrastructure.rest.model.ApiErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class ShopControllerMandatoryTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;


  @Test
  public void given_NoMandatoryAttributesInRequest() throws Exception {

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andReturn();
    final var responseString = result.getResponse().getContentAsString();

    final var apiErrorResponseList = this.objectMapper.readValue(responseString, new TypeReference<List<ApiErrorResponse>>() {});

    assertEquals(3, apiErrorResponseList.size());

    final var apiErrorPrice001Op = apiErrorResponseList.stream().filter(error -> error.getCode().equals(PriceError.PRICE_MANDATORY_DATE.getCode())).findFirst();
    assertTrue(apiErrorPrice001Op.isPresent());

    final var apiErrorPrice002Op = apiErrorResponseList.stream().filter(error -> error.getCode().equals(PriceError.PRICE_MANDATORY_BRAND_ID.getCode())).findFirst();
    assertTrue(apiErrorPrice002Op.isPresent());

    final var apiErrorPrice003Op = apiErrorResponseList.stream().filter(error -> error.getCode().equals(PriceError.PRICE_MANDATORY_PRODUCT_ID.getCode())).findFirst();
    assertTrue(apiErrorPrice003Op.isPresent());
  }
}
