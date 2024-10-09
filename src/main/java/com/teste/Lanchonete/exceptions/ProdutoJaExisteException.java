package com.teste.Lanchonete.exceptions;

public class ProdutoJaExisteException extends ErrorResponse{
    public ProdutoJaExisteException(){
        super("produto já existe!",409);
    }
}
