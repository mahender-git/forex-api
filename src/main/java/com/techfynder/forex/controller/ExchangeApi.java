package com.techfynder.forex.controller;

import com.techfynder.forex.ForexApplication;
import com.techfynder.forex.exception.TechfynderException;
import com.techfynder.forex.service.ExchangeService;
import com.techfynder.forex.vo.ExchangeRequest;
import com.techfynder.forex.vo.ExchangeResponse;
import com.techfynder.forex.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExchangeApi {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeApi.class.getName());
    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(method= RequestMethod.POST,value="/exchange",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getExchangeValue(@Valid @RequestBody ExchangeRequest exchangeRequest){
        long startTime = System.currentTimeMillis();
        logger.info("/exchange api received input request:{}",exchangeRequest);
        try{
            ExchangeResponse exchangeResponse = exchangeService.getExchangeValue(exchangeRequest);
            logger.info("exchange api service completed in:{} ms",(System.currentTimeMillis() - startTime));
            return new ResponseEntity<ExchangeResponse>(exchangeResponse, HttpStatus.OK);
        }catch (TechfynderException ex){
            ResponseObject responseObject = new ResponseObject("success",ex.getMessage(),exchangeRequest);
            return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
        }catch(Exception ex){
            ResponseObject responseObject = new ResponseObject("error",ex.getMessage(),exchangeRequest);
            return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
