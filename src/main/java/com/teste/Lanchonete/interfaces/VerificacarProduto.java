package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.entities.Produto;

import java.util.List;

public interface VerificacarProduto {
    void verificarProdutoPorNome(String produto);
    List<Produto> listarTodosProdutos();
    ProdutoDto listarProdutoPorId(Integer id);
}
