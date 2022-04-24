package com.example.demo.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_MAPPING")
public class CurrencyRepositoryEntity {

  @Id
  private String code;
  private String chineseName;

  public CurrencyRepositoryEntity() {
  }

  public CurrencyRepositoryEntity(String code, String chineseName) {
    this.code = code;
    this.chineseName = chineseName;
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
}
