package com.example.demo.controller;

import com.example.demo.dao.entity.CurrencyRepositoryEntity;
import com.example.demo.service.coindesk.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyMaintainController {

  @Autowired
  private CurrencyService currencyService;

  @GetMapping("currency")
  @ResponseBody
  public String selectCurrency(String code) {

    return currencyService.selectCurrencyName(code);
  }

  @PostMapping("currency")
  @ResponseBody
  public ResponseEntity<CurrencyRepositoryEntity> saveCurrency(String code, String chineseName) {

    CurrencyRepositoryEntity entity = currencyService.updateCurrency(code, chineseName);
    if (entity == null) {
      return new ResponseEntity<CurrencyRepositoryEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<CurrencyRepositoryEntity>(entity, HttpStatus.OK);
  }

  @PutMapping("currency")
  @ResponseBody
  public ResponseEntity<CurrencyRepositoryEntity> updateCurrency(String code, String chineseName) {

    CurrencyRepositoryEntity entity = currencyService.updateCurrency(code, chineseName);
    if (entity == null) {
      return new ResponseEntity<CurrencyRepositoryEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<CurrencyRepositoryEntity>(entity, HttpStatus.OK);
  }

  @DeleteMapping("currency")
  @ResponseBody
  public void deleteCurrency(String code) {

    currencyService.deleteCurrency(code);
  }
}
