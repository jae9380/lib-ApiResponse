package com.example.apiresponse.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomHttpStatus{
    private int statusCode;
    private String statusMessage;
}