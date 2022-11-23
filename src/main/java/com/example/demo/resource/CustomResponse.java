package com.example.demo.resource;

import lombok.Data;

@Data
public class CustomResponse {
    private String message;

    public CustomResponse(String message){
        this.message = message;
    }
}
