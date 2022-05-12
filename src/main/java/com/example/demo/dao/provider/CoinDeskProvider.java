package com.example.demo.dao.provider;

import com.example.demo.dao.entity.CurrencyPriceProviderEntity;
import com.example.demo.dto.CurrentPriceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("classpath:api.properties")
public class CoinDeskProvider implements ICoinDeskProvider {

  @Value("${get_coindesk_currentprice_url}")
  private String currentPriceUrl;

  @Override
  public CurrentPriceDto getCurrentPrice() {

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new JavaScriptMessageConverter());
    CurrencyPriceProviderEntity response = restTemplate.getForObject(currentPriceUrl, CurrencyPriceProviderEntity.class);
    if (response != null) {
      CurrentPriceDto.Time time = CurrentPriceDto.Time.builder().updated(response.getTime().getUpdatedISO()).build();
      CurrentPriceDto coinDeskDto = CurrentPriceDto.builder().time(time).build();

      Map<String, CurrentPriceDto.Currency> currencyMap = new HashMap<>();
      CurrencyPriceProviderEntity.Bpi.Currency usd = response.getBpi().getUSD();
      currencyMap.put("USD", new CurrentPriceDto.Currency(usd.getCode(), "", usd.getRate()));
      CurrencyPriceProviderEntity.Bpi.Currency gbp = response.getBpi().getGBP();
      currencyMap.put("GBP", new CurrentPriceDto.Currency(gbp.getCode(), "", gbp.getRate()));
      CurrencyPriceProviderEntity.Bpi.Currency eur = response.getBpi().getEUR();
      currencyMap.put("EUR", new CurrentPriceDto.Currency(eur.getCode(), "", eur.getRate()));

      coinDeskDto.setTime(time);
      coinDeskDto.setPbi(currencyMap);
      return coinDeskDto;
    }
    return null;
  }

  public class JavaScriptMessageConverter extends AbstractJackson2HttpMessageConverter {

    private JavaScriptMessageConverter() {
      super(Jackson2ObjectMapperBuilder.json().build(), new MediaType("application", "javascript"));
    }
  }
}
