package com.teste.Lanchonete.exceptions;

//import com.teste.Lanchonete.exceptions.CategoriaNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

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

    @ExceptionHandler({CategoriaJaExisteException.class})
    public ResponseEntity<Object> handleCategoriaJaExisteException(CategoriaJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NaoExitemCategoriasException.class})
    public ResponseEntity<Object> handleCategoriaNaoExisteException(NaoExitemCategoriasException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({FornecedorJaExisteException.class})
    public ResponseEntity<Object> handleCategoriaJaExisteException(FornecedorJaExisteException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NaoExistemFornecedoresException.class})
    public ResponseEntity<Object> handleCategoriaNaoExisteException(NaoExistemFornecedoresException ex) {
        return new ResponseEntity(ex.paraJson(), HttpStatus.NOT_FOUND);
    }

    // Captura erros gerais de sistema
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        // Cria uma instância de ErrorResponse
        ErrorResponse errorResponse = new ErrorResponse("Erro de validação", 400);
        errors.forEach((field, message) -> errorResponse.paraJson().put(field, message));
        return ResponseEntity.badRequest().body(errorResponse.paraJson());
    }

}