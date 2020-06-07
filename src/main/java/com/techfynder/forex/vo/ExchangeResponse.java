package com.techfynder.forex.vo;

import java.math.BigDecimal;
import java.util.Objects;

public class ExchangeResponse {
    private String exchangeDate;
    private String exchangeFrom;
    private String exchangeTo;
    private String baseCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal convertedValue;

    public ExchangeResponse() {

    }

    public ExchangeResponse(String exchangeDate,String exchangeFrom, String exchangeTo, String baseCurrency, BigDecimal exchangeRate, BigDecimal exchangeValue) {
        this.exchangeDate = exchangeDate;
        this.exchangeFrom = exchangeFrom;
        this.exchangeTo = exchangeTo;
        this.baseCurrency = baseCurrency;
        this.exchangeRate = exchangeRate;
        this.convertedValue = exchangeValue;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getExchangeFrom() {
        return exchangeFrom;
    }

    public void setExchangeFrom(String exchangeFrom) {
        this.exchangeFrom = exchangeFrom;
    }

    public String getExchangeTo() {
        return exchangeTo;
    }

    public void setExchangeTo(String exchangeTo) {
        this.exchangeTo = exchangeTo;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public String toString() {
        return "ExchangeResponse{" +
                "exchangeFrom='" + exchangeFrom + '\'' +
                ", exchangeTo='" + exchangeTo + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", exchageRate=" + exchangeRate +
                ", exchangeValue=" + convertedValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeResponse that = (ExchangeResponse) o;

        if (exchangeDate != null ? !exchangeDate.equals(that.exchangeDate) : that.exchangeDate != null) return false;
        if (exchangeFrom != null ? !exchangeFrom.equals(that.exchangeFrom) : that.exchangeFrom != null) return false;
        if (exchangeTo != null ? !exchangeTo.equals(that.exchangeTo) : that.exchangeTo != null) return false;
        if (baseCurrency != null ? !baseCurrency.equals(that.baseCurrency) : that.baseCurrency != null) return false;
        if (exchangeRate != null ? !exchangeRate.equals(that.exchangeRate) : that.exchangeRate != null) return false;
        return convertedValue != null ? convertedValue.equals(that.convertedValue) : that.convertedValue == null;
    }

    @Override
    public int hashCode() {
        int result = exchangeDate != null ? exchangeDate.hashCode() : 0;
        result = 31 * result + (exchangeFrom != null ? exchangeFrom.hashCode() : 0);
        result = 31 * result + (exchangeTo != null ? exchangeTo.hashCode() : 0);
        result = 31 * result + (baseCurrency != null ? baseCurrency.hashCode() : 0);
        result = 31 * result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
        result = 31 * result + (convertedValue != null ? convertedValue.hashCode() : 0);
        return result;
    }
}
