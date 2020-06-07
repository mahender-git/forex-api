package com.techfynder.forex.repositary;

import com.techfynder.forex.utils.DateUtils;
import com.techfynder.forex.vo.ExchangeRequest;
import com.techfynder.forex.vo.ExchangeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ExchangeResult getExchangeResult(ExchangeRequest exchangeRequest){
        Query query = exchangeResultQueryBuild(exchangeRequest);
        ExchangeResult exchangeResult = mongoTemplate.findOne(query,ExchangeResult.class);
        return exchangeResult;
    }

    private Query exchangeResultQueryBuild(ExchangeRequest exchangeRequest){
        Query query = new Query();
        query.addCriteria(Criteria.where("date").is(exchangeRequest.getExchangeDate() == null ? DateUtils.getCurrentZoneDate() : exchangeRequest.getExchangeDate()));
        return query;
    }
}
