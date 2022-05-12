package com.example.demo.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CURRENCY_MAPPING")
public class CurrencyRepositoryEntity {

  @Id
  private String code;
  private String chineseName;
}
