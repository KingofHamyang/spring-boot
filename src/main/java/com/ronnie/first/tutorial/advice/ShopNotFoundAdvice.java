package com.ronnie.first.tutorial.advice;

import com.ronnie.first.tutorial.exception.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShopNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ShopNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ShopNotFoundHandler(ShopNotFoundException e) {
        return e.getMessage();
    }
}
