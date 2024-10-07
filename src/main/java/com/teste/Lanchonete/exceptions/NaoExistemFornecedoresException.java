package com.teste.Lanchonete.exceptions;

public class NaoExistemFornecedoresException extends ErrorResponse{
    public NaoExistemFornecedoresException(){
        super("Não existem fornecedores cadastrados!", 404);
    }
}
