package com.teste.Lanchonete.exceptions;

public class NaoExisteEmpresaExciption extends ErrorResponse {
    public NaoExisteEmpresaExciption() {

        super("Não existe nenhuma empresa cadastrada!", 404);
    }
}
