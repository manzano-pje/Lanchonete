package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;

import java.util.List;

public interface VerificarFornecedor {
    Fornecedores verificarFornecedorPorId(Integer id);
    List<Fornecedores> buscarTodosFornecedores();
}
