package com.teste.Lanchonete.exceptions;

public class QuantidadeInvalidaExciption extends ErrorResponse {
    public QuantidadeInvalidaExciption(){
        super("Quantidade inválida!",409);
    }
}
