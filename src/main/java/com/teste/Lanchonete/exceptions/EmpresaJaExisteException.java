package com.teste.Lanchonete.exceptions;

public class EmpresaJaExisteException extends ErrorResponse {
    public EmpresaJaExisteException() {
        super("Empresa já existe no cadastro", 409);
    }
}
