package com.example.demo.controller;

import com.example.demo.dto.CurrentPriceDto;
import com.example.demo.service.coindesk.ICurrentPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrentPriceController {

  @Autowired
  private ICurrentPrice currentPriceService;

  @GetMapping("currentPrice")
  @ResponseBody
  public CurrentPriceDto searchCoinDesk() {

    return currentPriceService.searchCurrency();
  }
}
