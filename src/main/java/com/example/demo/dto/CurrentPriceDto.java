package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class CurrentPriceDto {

  private Time time;
  private Map<String, Currency> pbi = new HashMap<>();

  public Map<String, Currency> getPbi() {
    return pbi;
  }

  public void setPbi(Map<String, Currency> pbi) {
    this.pbi = pbi;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public static class Time {

    private String updated;

    public Time(String updated) {
      this.updated = updated;
    }

    public String getUpdated() {
      return updated;
    }

    public void setUpdated(String updated) {
      this.updated = updated;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Time{");
      sb.append("updated='").append(updated).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }

  public static class Currency {
    private String code;
    private String chineseName;
    private String rate;

    public Currency(String code, String chineseName, String rate) {
      this.code = code;
      this.chineseName = chineseName;
      this.rate = rate;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getChineseName() {
      return chineseName;
    }

    public void setChineseName(String chineseName) {
      this.chineseName = chineseName;
    }

    public String getRate() {
      return rate;
    }

    public void setRate(String rate) {
      this.rate = rate;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Currency{");
      sb.append("code='").append(code).append('\'');
      sb.append(", chineseName='").append(chineseName).append('\'');
      sb.append(", rate='").append(rate).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CurrentPriceDto{");
    sb.append("time=").append(time);
    sb.append(", pbi=").append(pbi);
    sb.append('}');
    return sb.toString();
  }
}
