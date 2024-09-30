package com.teste.Lanchonete.exceptions;

public class CategoriaJaExisteException extends ErrorResponse {
    public CategoriaJaExisteException(){
        super("Categoria já cadastrada!", 409);
    }
}
