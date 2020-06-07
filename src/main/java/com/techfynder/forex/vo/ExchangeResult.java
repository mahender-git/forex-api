package com.techfynder.forex.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Document(collection = "pract_coll")
public class ExchangeResult {
    @Id
    private String _id;
    private String baseCurrency;
    @Indexed
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date date;
    private Map<String, BigDecimal> rates;

    public ExchangeResult() {
    }

    public ExchangeResult(String _id, String baseCurrency, Date date, Map<String, BigDecimal> rates) {
        this._id = _id;
        this.baseCurrency = baseCurrency;
        this.date = date;
        this.rates = rates;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeResult{" +
                "_id='" + _id + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
