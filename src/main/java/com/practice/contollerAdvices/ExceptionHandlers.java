package com.practice.contollerAdvices;

import com.practice.Exception.ProductDeosntExist;
import com.practice.dto.ExceptionDto;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDto> handleNullPointerException()
    {
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage("Product Doesn't Exist");
        return new ResponseEntity<>(exceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ProductDeosntExist.class)
    public ResponseEntity<ExceptionDto> productNotExistException(ProductDeosntExist productDeosntExist)
    {
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage(productDeosntExist.getMessage());
        return new ResponseEntity<>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
