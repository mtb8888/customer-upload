package org.team.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GenericControllerAdvice {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String genericExceptionHandler(Exception e) {
        return e.getMessage();
    }
    //TODO come back and make more meaningful exception chains, catch all for now.
}
