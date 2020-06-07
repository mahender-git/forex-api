package com.techfynder.forex;

import com.techfynder.forex.repositary.ExchangeRepository;
import com.techfynder.forex.utils.DateUtils;
import com.techfynder.forex.vo.ExchangeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ForexApplication {
	private static final Logger logger = LoggerFactory.getLogger(ForexApplication.class.getName());

	@Autowired
	private MongoTemplate mongoTemplate;

	@Bean
	CommandLineRunner loadExchangeRates() throws Exception {
		Map<String, BigDecimal> exchangeRates = new HashMap();
		exchangeRates.put("USD",new BigDecimal("1"));
		exchangeRates.put("AED",new BigDecimal("3.672500"));
		exchangeRates.put("INR",new BigDecimal("75.369605"));
		exchangeRates.put("GBP",new BigDecimal("0.794266"));
		exchangeRates.put("EUR",new BigDecimal("0.889545"));
		exchangeRates.put("AUD",new BigDecimal("1.442550"));
		exchangeRates.put("JPY",new BigDecimal("109.570849"));

		return args -> {
			ExchangeResult exchangeResult = new ExchangeResult(DateUtils.generateSequenceKey(),"USD", DateUtils.getCurrentZoneDate(),exchangeRates);
			mongoTemplate.save(exchangeResult);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ForexApplication.class, args);
		logger.info("ForexApplication started..............");
	}

}
