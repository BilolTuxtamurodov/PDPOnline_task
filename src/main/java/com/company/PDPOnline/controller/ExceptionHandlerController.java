package com.company.PDPOnline.controller;

import com.company.PDPOnline.exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<?> handler(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
