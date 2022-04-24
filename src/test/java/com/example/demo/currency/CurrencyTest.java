package com.example.demo.currency;

import com.example.demo.dao.provider.ICoinDeskProvider;
import com.example.demo.dto.CurrentPriceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ICoinDeskProvider coinDeskProvider;

  @Test
  public void selectCurrencyTable() throws Exception {

    mockMvc.perform(get("/currency?code=USD")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("美金")));
    mockMvc.perform(get("/currency?code=GBP")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("英鎊")));
    mockMvc.perform(get("/currency?code=EUR")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("歐元")));
  }

  @Test
  public void saveCurrencyTable() throws Exception {

    ResultActions resultActions = mockMvc.perform(post("/currency", "addTest", "新增幣別")
                    .param("code", "addTest")
                    .param("chineseName", "新增幣別"));
    resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
    resultActions.andExpect(status().isOk()).andExpect(content().string(containsString("{\"code\":\"addTest\",\"chineseName\":\"新增幣別\"}")));
  }

  @Test
  public void updateCurrencyTable() throws Exception {

    ResultActions resultActions = mockMvc.perform(put("/currency", "addTest", "更新幣別")
            .param("code","addTest")
            .param("chineseName","更新幣別"));
    resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
    resultActions.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("{\"code\":\"addTest\",\"chineseName\":\"更新幣別\"}")));
  }

  @Test
  public void deleteCurrencyTable() throws Exception {

    mockMvc.perform(delete("/currency")
            .param("code","addTest")).andExpect(status().isOk());
  }

  @Test
  public void callCoinDeskApi() throws Exception {

    CurrentPriceDto currentPriceDto = coinDeskProvider.getCurrentPrice();
    Assertions.assertEquals("USD", currentPriceDto.getPbi().get("USD").getCode());
    Assertions.assertEquals("GBP", currentPriceDto.getPbi().get("GBP").getCode());
    Assertions.assertEquals("EUR", currentPriceDto.getPbi().get("EUR").getCode());
    System.out.println(currentPriceDto);
  }

  @Test
  public void callCurrentPrice() throws Exception {

    mockMvc.perform(get("/currentPrice")).andDo(print()).andExpect(status().isOk());
  }
}
