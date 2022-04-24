package com.example.demo.service.coindesk;

import com.example.demo.dao.entity.CurrencyRepositoryEntity;
import com.example.demo.dao.repository.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService implements ICurrency {

  @Autowired
  private ICurrencyRepository iCurrencyRepository;

  @Override
  public String selectCurrencyName(String code) {

    Optional<CurrencyRepositoryEntity> entity = iCurrencyRepository.findById(code);
    if (entity.isPresent()) {
      return entity.get().getChineseName();
    }
    return "";
  }

  @Override
  public CurrencyRepositoryEntity updateCurrency(String code, String name) {
    CurrencyRepositoryEntity entity = new CurrencyRepositoryEntity();
    entity.setCode(code);
    entity.setChineseName(name);
    try {
      iCurrencyRepository.save(entity);
    } catch (Exception e) {
      return null;
    }
    return entity;
  }

  @Override
  public void deleteCurrency(String code) {

    iCurrencyRepository.deleteById(code);
  }
}
