package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Produtos;

import java.util.List;

public interface VerificacarProdutos {
    void verificarProdutoPorNome(String produto);
    List<Produtos> listarTodosProdutos();
}
