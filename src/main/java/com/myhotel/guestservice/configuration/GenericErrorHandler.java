package com.myhotel.guestservice.configuration;

import com.myhotel.guestservice.exception.GuestNotFoundException;
import com.myhotel.guestservice.model.response.GenericErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice(basePackages = "com.myhotel.guestservice.contract")
public class GenericErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> guestNotFound(final GuestNotFoundException exception){

        GenericErrorResponse errorResponse = GenericErrorResponse.builder()
                .errorCode(101)
                .errorMessage(exception.getMessage())
                .build();

        log.error("event=createWorkFlow, errorResponse = {}", errorResponse);

        return ResponseEntity.badRequest().body(errorResponse);


    }
}
