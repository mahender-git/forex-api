package com.techfynder.forex.service;

import com.techfynder.forex.vo.ExchangeRequest;
import com.techfynder.forex.vo.ExchangeResponse;

public interface ExchangeService {

    public ExchangeResponse getExchangeValue(ExchangeRequest exchangeRequest);

}
