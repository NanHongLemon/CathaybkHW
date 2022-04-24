package com.example.demo.service.coindesk;

import com.example.demo.dao.provider.ICoinDeskProvider;
import com.example.demo.dto.CurrentPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CurrentPriceService implements ICurrentPrice {

  private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
  private final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

  @Autowired
  private ICoinDeskProvider coinDeskProvider;
  @Autowired
  private ICurrency currencyService;

  @Override
  public CurrentPriceDto searchCurrency() {
    CurrentPriceDto currentPriceDto = coinDeskProvider.getCurrentPrice();
    if (currentPriceDto != null) {
      LocalDateTime dateTime = LocalDateTime.parse(currentPriceDto.getTime().getUpdated(), formatter);
      currentPriceDto.getTime().setUpdated(dateTime.format(formatter2));

      currentPriceDto.getPbi().entrySet().forEach(entry -> {
        entry.getValue().setChineseName(currencyService.selectCurrencyName(entry.getValue().getCode()));
      });
    }

    return currentPriceDto;
  }
}
