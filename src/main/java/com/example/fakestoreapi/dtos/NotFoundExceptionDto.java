package com.example.fakestoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class NotFoundExceptionDto
{
    private HttpStatus errorCode;
    private String errorMessage;

//    public NotFoundExceptionDto(HttpStatus errorCode,String errorMessage)
//    {
//        this.errorCode = errorCode;
//        this.errorMessage = errorMessage;
//    }


}
