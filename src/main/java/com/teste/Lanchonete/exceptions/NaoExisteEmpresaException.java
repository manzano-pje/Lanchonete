package com.teste.Lanchonete.exceptions;

public class NaoExisteEmpresaException extends ErrorResponse {
    public NaoExisteEmpresaException() {

        super("Não existe nenhuma empresa cadastrada!", 404);
    }
}
