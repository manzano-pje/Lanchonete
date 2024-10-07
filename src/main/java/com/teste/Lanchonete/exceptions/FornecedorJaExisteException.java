package com.teste.Lanchonete.exceptions;

public class FornecedorJaExisteException extends ErrorResponse {
    public FornecedorJaExisteException(){
        super("Fornecedor já cadastrado!", 409);
    }
}
