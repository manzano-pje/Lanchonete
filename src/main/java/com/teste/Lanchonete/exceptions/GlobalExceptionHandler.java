//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.teste.Lanchonete.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({ErroDoServidorException.class})
    public ResponseEntity<Object> handleErroDoServidor(EmpresaJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({EmpresaJaExisteException.class})
    public ResponseEntity<Object> handleEmpresaJaExisteException(EmpresaJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NaoExisteEmpresaExciption.class})
    public ResponseEntity<Object> handleNaoExisteEmpresaExciption(NaoExisteEmpresaExciption ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.NOT_FOUND);
    }
}