package com.example.demo.dao.provider;

import com.example.demo.dto.CurrentPriceDto;

public interface ICoinDeskProvider {

  public CurrentPriceDto getCurrentPrice();
}
