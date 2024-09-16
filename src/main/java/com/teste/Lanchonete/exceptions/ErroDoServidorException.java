package com.teste.Lanchonete.exceptions;

public class ErroDoServidorException extends ErrorResponse {
    public ErroDoServidorException() {
        super("Erro interno do servidor", 500);
    }
}
