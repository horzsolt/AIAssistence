package com.etalon.aidemo.aidemo.ordermanagement;

public class OrderNotFoundException extends RuntimeException {
    
    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
