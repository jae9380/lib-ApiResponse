package com.example.apiresponse.exception;

import com.example.apiresponse.apiResponse.ApiResponse;
import com.example.apiresponse.apiResponse.Empty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Empty> handleValidException(MethodArgumentNotValidException e) {

        List<String> errorMessages = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .toList();

        log.error(errorMessages.toString());

        CustomHttpStatus customHttpStatus = CustomHttpStatus.builder()
                .statusCode(400)
                .statusMessage(errorMessages.get(0))
                .build();

        return ApiResponse.validationException(customHttpStatus);
    }

    @ExceptionHandler(GincException.class)
    public ApiResponse<Empty> handleCustomException(GincException goohaeyouException) {

        log.error(goohaeyouException.getErrorCode() + ": " + goohaeyouException.getMessage());

        return ApiResponse.customException(goohaeyouException.getErrorCode());
    }
}
