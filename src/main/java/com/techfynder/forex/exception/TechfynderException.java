package com.techfynder.forex.exception;

public class TechfynderException extends RuntimeException{

    public TechfynderException(){
        super();
    }

    public TechfynderException(String exceptionMsg){
        super(exceptionMsg);
    }

    public TechfynderException(String exceptionMsg,Throwable throwable){
        super(exceptionMsg,throwable);
    }


}
