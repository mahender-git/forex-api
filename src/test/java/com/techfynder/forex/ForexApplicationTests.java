package com.techfynder.forex;

import com.techfynder.forex.exception.TechfynderException;
import com.techfynder.forex.repositary.ExchangeRepository;
import com.techfynder.forex.service.ExchangeService;
import com.techfynder.forex.utils.DateUtils;
import com.techfynder.forex.vo.ExchangeRequest;
import com.techfynder.forex.vo.ExchangeResponse;
import com.techfynder.forex.vo.ExchangeResult;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class ForexApplicationTests extends TestCase {

	@Autowired
	private ExchangeService exchangeService;

	@MockBean
	private ExchangeRepository exchangeRepository;

	@Test
	public void exchangeServiceTest(){
		ExchangeResult exchangeResult = null;
		ExchangeRequest exchangeRequest = null;
		Mockito.when(exchangeRepository.getExchangeResult(exchangeRequest)).thenReturn(exchangeResult);
		Throwable exception = assertThrows(TechfynderException.class, () -> exchangeService.getExchangeValue(exchangeRequest));
		assertEquals("Data not found in db", exception.getMessage());
	}

	@Test
	public void exchangeServiceForExceptionClassTest(){
		ExchangeResult exchangeResult = null;
		ExchangeRequest exchangeRequest = null;
		ExchangeResponse exchangeResponse = null;
		Mockito.when(exchangeRepository.getExchangeResult(exchangeRequest)).thenReturn(exchangeResult);
		Throwable exception = assertThrows(TechfynderException.class, () -> exchangeService.getExchangeValue(exchangeRequest));
		assertTrue(exception instanceof TechfynderException);
	}

	@Test
	public void testGetExchangeValue() throws ParseException {
		String exchangeDateString="04-06-2020";
		String exchangeFrom = "INR";
		String exchangeTo = "AED";
		String baseExchange = "USD";
		BigDecimal exchangeFromValue = new BigDecimal("75.369605");
		BigDecimal exchangeToValue = new BigDecimal("3.672500");

		Map<String,BigDecimal> exchangeRates = new HashMap();
		exchangeRates.put("AED",new BigDecimal("3.672500"));
		exchangeRates.put("INR",new BigDecimal("75.369605"));
		exchangeRates.put("GBP",new BigDecimal("0.794266"));

		Date exchangeDate= DateUtils.convertStringToDate(exchangeDateString);
		ExchangeRequest exchangeRequest = new ExchangeRequest(exchangeFrom,exchangeFromValue,exchangeTo,exchangeDate);
		ExchangeResponse exchangeResponse = new ExchangeResponse(exchangeDateString,exchangeFrom,exchangeTo,baseExchange,exchangeFromValue,exchangeToValue);
		ExchangeResult exchangeResult = new ExchangeResult("1",baseExchange,exchangeDate,exchangeRates);
		Mockito.when(exchangeRepository.getExchangeResult(exchangeRequest)).thenReturn(exchangeResult);
		assertEquals(exchangeResponse.toString(),exchangeService.getExchangeValue(exchangeRequest).toString());
	}
	@Test
	public void exchangeRatesNotFoundInDB() throws ParseException {
		String exchangeDateString="04-06-2020";
		String exchangeFrom = "INR";
		String exchangeTo = "USD";
		String baseExchange = "USD";
		BigDecimal exchangeFromValue = new BigDecimal("75.369605");
		BigDecimal exchangeToValue = new BigDecimal("3.672500");

		Map<String,BigDecimal> exchangeRates = new HashMap();
		exchangeRates.put("AED",new BigDecimal("3.672500"));
		exchangeRates.put("INR",new BigDecimal("75.369605"));
		exchangeRates.put("GBP",new BigDecimal("0.794266"));

		Date exchangeDate= DateUtils.convertStringToDate(exchangeDateString);
		ExchangeRequest exchangeRequest = new ExchangeRequest(exchangeFrom,exchangeFromValue,exchangeTo,exchangeDate);
		ExchangeResponse exchangeResponse = new ExchangeResponse(exchangeDateString,exchangeFrom,exchangeTo,baseExchange,exchangeFromValue,exchangeToValue);
		ExchangeResult exchangeResult = new ExchangeResult("1",baseExchange,exchangeDate,exchangeRates);
		Mockito.when(exchangeRepository.getExchangeResult(exchangeRequest)).thenReturn(exchangeResult);
		Throwable exception = assertThrows(TechfynderException.class, () -> exchangeService.getExchangeValue(exchangeRequest));
		assertEquals("exchange rates not found for: "+exchangeFrom+" to "+exchangeTo, exception.getMessage());
	}

}
