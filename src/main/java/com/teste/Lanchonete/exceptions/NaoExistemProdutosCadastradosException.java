package com.teste.Lanchonete.exceptions;

public class NaoExistemProdutosCadastradosException extends ErrorResponse {
    public NaoExistemProdutosCadastradosException(){
        super("Não existem produtos cadastrados!", 404);
    }
}
