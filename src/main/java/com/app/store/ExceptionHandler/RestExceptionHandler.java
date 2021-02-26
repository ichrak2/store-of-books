package com.app.store.ExceptionHandler;

import com.app.store.entity.BookNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleBookNotFoundException() {
        log.warn("this book not found");
    }
}
