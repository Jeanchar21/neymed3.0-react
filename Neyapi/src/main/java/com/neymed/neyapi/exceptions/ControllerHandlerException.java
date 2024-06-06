package com.neymed.neyapi.exceptions;

import com.neymed.neyapi.services.exceptions.DataIntegretionException;
import com.neymed.neyapi.services.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerHandlerException {
        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<CorpoExcessao> NotFoundException(NotFoundException e, HttpServletRequest request){
            String error = "Usuário não encontrado";
            HttpStatus status = HttpStatus.NOT_FOUND;
            CorpoExcessao err = new CorpoExcessao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

            return ResponseEntity.status(status).body(err);
        }
        @ExceptionHandler(DataIntegretionException.class)
        public ResponseEntity<CorpoExcessao> DataIntegretionException(DataIntegretionException x, HttpServletRequest request){
            String error = x.getMessage();
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            CorpoExcessao err = new CorpoExcessao(Instant.now(), status.value(), error, x.getMessage(), request.getRequestURI());

            return ResponseEntity.status(status).body(err);
        }
}
