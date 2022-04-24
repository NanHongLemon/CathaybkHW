package com.example.demo.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrenctPriceProviderEntity {

  private Time time;
  private String disclaimer;
  private String chartName;
  private Bpi bpi;

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  public String getChartName() {
    return chartName;
  }

  public void setChartName(String chartName) {
    this.chartName = chartName;
  }

  public Bpi getBpi() {
    return bpi;
  }

  public void setBpi(Bpi bpi) {
    this.bpi = bpi;
  }

  public static class Time {

    private String updated;
    private String updatedISO;
    private String updateduk;

    public String getUpdated() {
      return updated;
    }

    public void setUpdated(String updated) {
      this.updated = updated;
    }

    public String getUpdatedISO() {
      return updatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
      this.updatedISO = updatedISO;
    }

    public String getUpdateduk() {
      return updateduk;
    }

    public void setUpdateduk(String updateduk) {
      this.updateduk = updateduk;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Time{");
      sb.append("updated='").append(updated).append('\'');
      sb.append(", updatedISO='").append(updatedISO).append('\'');
      sb.append(", updateduk='").append(updateduk).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }

  public static class Bpi {

    @JsonProperty("USD")
    private Currency USD;
    @JsonProperty("GBP")
    private Currency GBP;
    @JsonProperty("EUR")
    private Currency EUR;

    public Currency getUSD() {
      return USD;
    }

    public void setUSD(Currency USD) {
      this.USD = USD;
    }

    public Currency getGBP() {
      return GBP;
    }

    public void setGBP(Currency GBP) {
      this.GBP = GBP;
    }

    public Currency getEUR() {
      return EUR;
    }

    public void setEUR(Currency EUR) {
      this.EUR = EUR;
    }

    public static class Currency {

      private String code;
      private String symbol;
      private String rate;
      private String description;
      private float rate_float;

      public String getCode() {
        return code;
      }

      public void setCode(String code) {
        this.code = code;
      }

      public String getSymbol() {
        return symbol;
      }

      public void setSymbol(String symbol) {
        this.symbol = symbol;
      }

      public String getRate() {
        return rate;
      }

      public void setRate(String rate) {
        this.rate = rate;
      }

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public float getRate_float() {
        return rate_float;
      }

      public void setRate_float(float rate_float) {
        this.rate_float = rate_float;
      }

      @Override
      public String toString() {
        final StringBuilder sb = new StringBuilder("Currency{");
        sb.append("code='").append(code).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", rate='").append(rate).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", rate_float='").append(rate_float).append('\'');
        sb.append('}');
        return sb.toString();
      }
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Bpi{");
      sb.append("USD=").append(USD);
      sb.append(", GBP=").append(GBP);
      sb.append(", EUR=").append(EUR);
      sb.append('}');
      return sb.toString();
    }
  }
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CurrentPriceProviderEntity{");
    sb.append("time=").append(time);
    sb.append(", disclaimer='").append(disclaimer).append('\'');
    sb.append(", chartName='").append(chartName).append('\'');
    sb.append(", bpi=").append(bpi);
    sb.append('}');
    return sb.toString();
  }
}
