package com.techfynder.forex.service;

import com.techfynder.forex.exception.TechfynderException;
import com.techfynder.forex.repositary.ExchangeRepository;
import com.techfynder.forex.utils.DateUtils;
import com.techfynder.forex.utils.TechfynderConstants;
import com.techfynder.forex.vo.ExchangeRequest;
import com.techfynder.forex.vo.ExchangeResponse;
import com.techfynder.forex.vo.ExchangeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class.getName());

    @Autowired
    ExchangeRepository exchangeRepository;

    @Override
    public ExchangeResponse getExchangeValue(ExchangeRequest exchangeRequest) {
        long startTime = System.currentTimeMillis();
        ExchangeResult exchangeResult = exchangeRepository.getExchangeResult(exchangeRequest);
        if(exchangeResult == null){
            throw new TechfynderException("Data not found in db");
        }
        ExchangeResponse exchangeResponse = null;
        if(exchangeResult.getRates().containsKey(exchangeRequest.getExchangeFrom()) && exchangeResult.getRates().containsKey(exchangeRequest.getExchangeTo())){
            exchangeResponse = new ExchangeResponse();
            exchangeResponse.setExchangeDate(DateUtils.convertUtilDateToString(exchangeRequest.getExchangeDate(),TechfynderConstants.DD_MMM_YYYY));
            exchangeResponse.setExchangeFrom(exchangeRequest.getExchangeFrom());
            exchangeResponse.setExchangeTo(exchangeRequest.getExchangeTo());
            exchangeResponse.setBaseCurrency(exchangeResult.getBaseCurrency());
            BigDecimal localExchangeRate = exchangeResult.getRates().get(exchangeRequest.getExchangeFrom());
            BigDecimal foreignExchangeRate = exchangeResult.getRates().get(exchangeRequest.getExchangeTo());
            exchangeResponse.setExchangeRate(exchangeResult.getRates().get(exchangeRequest.getExchangeFrom()));
            exchangeResponse.setConvertedValue(calculateExchangeValue(localExchangeRate,foreignExchangeRate,exchangeRequest.getExchangeValue()));
        }else{
            logger.info("exchange rates not found for {} to {}",exchangeRequest.getExchangeFrom(),exchangeRequest.getExchangeTo());
            throw new TechfynderException("exchange rates not found for: "+exchangeRequest.getExchangeFrom()+" to "+ exchangeRequest.getExchangeTo());
        }
        logger.info("getExchangeValue service method completed in {} ms", (System.currentTimeMillis() - startTime));
        return exchangeResponse;
    }

    public BigDecimal calculateExchangeValue(BigDecimal localExchangeRate,BigDecimal foreinExchangeRate,BigDecimal localValue){
        //convert to local currency to usd -> ex: 100 INR converts to 1.13 USD
        BigDecimal convertedBaseValue  = localValue.divide(localExchangeRate, TechfynderConstants.DECIMAL_PLACES_ROUND_OFF, RoundingMode.HALF_EVEN);
        //convert basevalue to foreign value
        return convertedBaseValue.multiply(foreinExchangeRate).setScale(TechfynderConstants.DECIMAL_PLACES_ROUND_OFF, BigDecimal.ROUND_HALF_EVEN);
    }

}
