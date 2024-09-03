package com.practice.Exception;

import com.practice.dto.ExceptionDto;

public class ProductDeosntExist extends Exception {

    public ProductDeosntExist(String message)
    {
        super(message);
    }
}
