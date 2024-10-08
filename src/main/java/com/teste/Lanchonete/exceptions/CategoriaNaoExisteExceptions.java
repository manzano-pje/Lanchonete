package com.teste.Lanchonete.exceptions;

public class CategoriaNaoExisteExceptions extends ErrorResponse{
    public CategoriaNaoExisteExceptions(){
        super("Categoria não cadastrada!", 404);
    }
}
