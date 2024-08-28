package com.example.datajpaexceptions.handler;

import com.example.datajpaexceptions.exception.BadRequestException;
import com.example.datajpaexceptions.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.example.datajpaexceptions.constants.ExceptionConstants.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object>handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        logger.info("Entity Not Found Exception");
        Map<String,String> body=new HashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now().toString());
        body.put(STATUS, String.valueOf(HttpStatus.NOT_FOUND.value()));
        body.put(ERROR,"Not Found");
        body.put(MESSAGE,ex.getMessage());
        body.put(PATH,request.getDescription(false));
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public  ResponseEntity<Object>handleBadRequestException(BadRequestException e,WebRequest request){
        Map<String,String> body=new HashMap<>();
        body.put(TIMESTAMP,LocalDateTime.now().toString());
        body.put(STATUS,String.valueOf(HttpStatus.NOT_FOUND.value()));
        body.put(ERROR,"Not Found");
        body.put(MESSAGE,e.getMessage());
        body.put(PATH,request.getDescription(false));
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(WebRequest request){
        Map<String,String>body=new HashMap<>();
        body.put("timestamp",LocalDateTime.now().toString());
        body.put(STATUS,HttpStatus.INTERNAL_SERVER_ERROR.toString());
        body.put(ERROR,"Internal Server Error");
        body.put(MESSAGE,"An unexpected error occured");
        body.put(PATH,request.getDescription(false));
        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
}
