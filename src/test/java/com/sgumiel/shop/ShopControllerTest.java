package com.sgumiel.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgumiel.shop.infrastructure.rest.model.PriceResponse;
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
public class ShopControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void test01() throws Exception {

    final var brandId = 1;
    final var productId = 35455;
    final var date = "2020-06-14 10:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final var dateTime = LocalDateTime.parse(date, formatter);

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .param("brandId", brandId + "")
            .param("productId", productId+ "")
            .param("date", date)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    final var price = this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<PriceResponse>() {});

    assertEquals(35.5, price.getPrice());
    assertEquals(productId, price.getProductId());
    assertEquals(brandId, price.getBrandId());
    assertEquals(1, price.getPriceList());
    assertTrue(price.getStartDate().isBefore(dateTime));
    assertTrue(price.getEndDate().isAfter(dateTime));

  }

  @Test
  public void test02() throws Exception {

    final var brandId = 1;
    final var productId = 35455;
    final var date = "2020-06-14 16:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final var dateTime = LocalDateTime.parse(date, formatter);

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .param("brandId", brandId + "")
            .param("productId", productId+ "")
            .param("date", date)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    final var price = this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<PriceResponse>() {});

    assertEquals(25.45, price.getPrice());
    assertEquals(productId, price.getProductId());
    assertEquals(brandId, price.getBrandId());
    assertEquals(2, price.getPriceList());
    assertTrue(price.getStartDate().isBefore(dateTime));
    assertTrue(price.getEndDate().isAfter(dateTime));

  }

  @Test
  public void test03() throws Exception {

    final var brandId = 1;
    final var productId = 35455;
    final var date = "2020-06-14 21:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final var dateTime = LocalDateTime.parse(date, formatter);

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .param("brandId", brandId + "")
            .param("productId", productId+ "")
            .param("date", date)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    final var price = this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<PriceResponse>() {});

    assertEquals(35.5, price.getPrice());
    assertEquals(productId, price.getProductId());
    assertEquals(brandId, price.getBrandId());
    assertEquals(1, price.getPriceList());
    assertTrue(price.getStartDate().isBefore(dateTime));
    assertTrue(price.getEndDate().isAfter(dateTime));

  }

  @Test
  public void test04() throws Exception {

    final var brandId = 1;
    final var productId = 35455;
    final var date = "2020-06-15 10:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final var dateTime = LocalDateTime.parse(date, formatter);

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .param("brandId", brandId + "")
            .param("productId", productId+ "")
            .param("date", date)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    final var price = this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<PriceResponse>() {});

    assertEquals(30.5, price.getPrice());
    assertEquals(productId, price.getProductId());
    assertEquals(brandId, price.getBrandId());
    assertEquals(3, price.getPriceList());
    assertTrue(price.getStartDate().isBefore(dateTime));
    assertTrue(price.getEndDate().isAfter(dateTime));

  }

  @Test
  public void test05() throws Exception {

    final var brandId = 1;
    final var productId = 35455;
    final var date = "2020-06-16 21:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final var dateTime = LocalDateTime.parse(date, formatter);

    final var result = mvc.perform(MockMvcRequestBuilders.get("/price")
            .param("brandId", brandId + "")
            .param("productId", productId+ "")
            .param("date", date)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    final var price = this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<PriceResponse>() {});

    assertEquals(38.95, price.getPrice());
    assertEquals(productId, price.getProductId());
    assertEquals(brandId, price.getBrandId());
    assertEquals(4, price.getPriceList());
    assertTrue(price.getStartDate().isBefore(dateTime));
    assertTrue(price.getEndDate().isAfter(dateTime));

  }
}
