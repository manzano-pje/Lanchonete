package com.teste.Lanchonete.exceptions;

public class NaoExitemCategoriasException extends ErrorResponse {
    public NaoExitemCategoriasException(){
        super("Não existem categorias cadastradas!", 404);
    }
}
