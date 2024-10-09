package com.teste.Lanchonete.exceptions;

public class ProdutoJaCadastradoExceptions extends ErrorResponse {
    public ProdutoJaCadastradoExceptions(){
        super("Produto já cadastrado!",409);
    }
}
