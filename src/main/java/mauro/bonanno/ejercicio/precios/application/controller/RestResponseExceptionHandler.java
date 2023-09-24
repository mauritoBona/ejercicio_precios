package mauro.bonanno.ejercicio.precios.application.controller;

import mauro.bonanno.ejercicio.precios.application.exceptions.NotFoundException;
import mauro.bonanno.ejercicio.precios.application.response.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorDTO(ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
