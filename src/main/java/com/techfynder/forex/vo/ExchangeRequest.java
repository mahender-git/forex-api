package com.techfynder.forex.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.techfynder.forex.utils.TechfynderConstants;


import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRequest {

    @NotNull(message = TechfynderConstants.EXCHANGE_FROM_CURRENCY_SHOULD_NOT_EMPTY)
    @NotEmpty(message = TechfynderConstants.EXCHANGE_FROM_CURRENCY_SHOULD_NOT_EMPTY)
    private String exchangeFrom;
    @NotNull(message = TechfynderConstants.EXCHANGE_TO_CURRENCY_SHOULD_NOT_EMPTY)
    @NotEmpty(message = TechfynderConstants.EXCHANGE_TO_CURRENCY_SHOULD_NOT_EMPTY)
    private String exchangeTo;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = TechfynderConstants.INVALID_DATE)
    private Date exchangeDate;
    @Min(value = 1,message=TechfynderConstants.EXCHANGE_FROM_CURRENCY_SHOULD_GREATER_THAN_ZERO)
    private BigDecimal exchangeValue;




    public ExchangeRequest() {
    }

    public ExchangeRequest(String exchangeFrom, BigDecimal exchangeValue, String exchangeTo, Date exchangeDate) {
        this.exchangeFrom = exchangeFrom;
        this.exchangeValue = exchangeValue;
        this.exchangeTo = exchangeTo;
        this.exchangeDate = exchangeDate;
    }

    public String getExchangeFrom() {
        return exchangeFrom;
    }

    public void setExchangeFrom(String exchangeFrom) {
        this.exchangeFrom = exchangeFrom;
    }

    public BigDecimal getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(BigDecimal exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public String getExchangeTo() {
        return exchangeTo;
    }

    public void setExchangeTo(String exchangeTo) {
        this.exchangeTo = exchangeTo;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "ExchangeRequest{" +
                "exchangeFrom='" + exchangeFrom + '\'' +
                ", exchangeTo='" + exchangeTo + '\'' +
                ", exchangeDate=" + exchangeDate +
                ", amount=" + exchangeValue +
                '}';
    }
}
