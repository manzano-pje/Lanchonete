package com.teste.Lanchonete.exceptions;

//import com.teste.Lanchonete.exceptions.CategoriaNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({ErroDoServidorException.class})
    public ResponseEntity<Object> handleErroDoServidorException(ErroDoServidorException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({EmpresaJaExisteException.class})
    public ResponseEntity<Object> handleEmpresaJaExisteException(EmpresaJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NaoExisteEmpresaException.class})
    public ResponseEntity<Object> handleNaoExisteEmpresaExciption(NaoExisteEmpresaException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler({CategoriaJaExisteException.class})
//    public ResponseEntity<Object> handleCategoriaJaExisteException(CategoriaJaExisteException ex) {
//        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
//    }

    @ExceptionHandler({CategoriaJaExisteException.class})
    public ResponseEntity<Object> handleCategoriaJaExisteException(CategoriaJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
    }


}