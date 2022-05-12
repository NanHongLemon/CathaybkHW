package com.example.demo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
@Builder
public class CurrentPriceDto {

  private Time time;
  private Map<String, Currency> pbi = new HashMap<>();

  @AllArgsConstructor
  @Data
  @Builder
  public static class Time {

    private String updated;
  }

  @AllArgsConstructor
  @Data
  @Builder
  public static class Currency {
    private String code;
    private String chineseName;
    private String rate;
  }
}
