package com.practice.Exception;

import com.practice.dto.ExceptionDto;

public class ProductDoesntExist extends Exception {

    public ProductDoesntExist(String message)
    {
        super(message);
    }
}
