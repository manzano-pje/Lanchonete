package com.teste.Lanchonete.exceptions;

public class ClienteJaCadastradoException extends ErrorResponse {
    public ClienteJaCadastradoException(){
        super("Cliente já cadastrado", 409);
    }
}
