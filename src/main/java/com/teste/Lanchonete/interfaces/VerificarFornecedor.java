package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Fornecedores;
import java.util.List;

public interface VerificarFornecedor {
    Fornecedores verificarFornecedorPorId(Integer id);
    List<Fornecedores> buscarTodosFornecedores();
}
