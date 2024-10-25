package com.br.exemplo.crud.handlers;

import com.br.exemplo.crud.dtos.ResponseErroDTO;
import com.br.exemplo.crud.exceptions.NegocioException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erros);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ResponseErroDTO> handleCustomException(NegocioException ex) {
        var erros = new ResponseErroDTO(List.of(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erros);
    }
}
