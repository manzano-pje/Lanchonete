package com.teste.Lanchonete.exceptions;

public class ProdutoNaoCadastradoException extends ErrorResponse{
    public ProdutoNaoCadastradoException(){
        super("Produto não cadastrado!", 404);
    }
}
