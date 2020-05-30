package com.ronnie.first.tutorial.exception;

public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException(Long id) {
        super("Could not find shop " + id);
    }
}
