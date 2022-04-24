package com.example.demo.service.coindesk;

import com.example.demo.dao.entity.CurrencyRepositoryEntity;

import java.util.Optional;

public interface ICurrency {

  public String selectCurrencyName(String code);

  public CurrencyRepositoryEntity updateCurrency(String code, String name);

  public void deleteCurrency(String code);
}
