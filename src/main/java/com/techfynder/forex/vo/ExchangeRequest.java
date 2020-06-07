package com.techfynder.forex.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.techfynder.forex.utils.TechfynderConstants;


import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRequest {

    private String localCurrency;
    private BigDecimal amount;
    private String exchangeCurrency;


    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = TechfynderConstants.INVALID_DATE)
    private Date date;


    public ExchangeRequest() {
    }

    public ExchangeRequest(String localCurrency, BigDecimal amount, String exchangeCurrency,Date date) {
        this.localCurrency = localCurrency;
        this.amount = amount;
        this.exchangeCurrency = exchangeCurrency;
        this.date = date;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(String exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }

    @NotNull(message = TechfynderConstants.INVALID_DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeRequest{" +
                "localCurrency='" + localCurrency + '\'' +
                ", amount=" + amount +
                ", exchangeCurrency='" + exchangeCurrency + '\'' +
                '}';
    }
}
