package com.teste.Lanchonete.exceptions;

public class DataInvalidaException extends ErrorResponse {

    public DataInvalidaException(){
        super("Data inválida", 412);
    }

}
