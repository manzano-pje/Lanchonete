package com.teste.Lanchonete.exceptions;

public class EmpresaJaExisteException extends ErrorResponse {
    public EmpresaJaExisteException() {

        super("Já existe uma empresa no cadastro", 409);
    }
}
