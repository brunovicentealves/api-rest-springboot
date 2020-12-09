package br.com.spring.awesome.handler;

import br.com.spring.awesome.error.ResourceNotFoundDetails;
import br.com.spring.awesome.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rfnDetails = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return  new ResponseEntity<>(rfnDetails,HttpStatus.NOT_FOUND);
    }

}
