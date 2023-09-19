package com.example.fakestoreapi.exceptions;

import org.springframework.stereotype.Component;


public class NotFoundException extends Exception{

    public NotFoundException(String message)
    {
        super(message);
    }
}
