package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Fornecedor;

import java.util.List;

public interface VerificarFornecedor {
    Fornecedor verificarFornecedorPorId(Integer id);
    List<Fornecedor> buscarTodosFornecedores();
}
