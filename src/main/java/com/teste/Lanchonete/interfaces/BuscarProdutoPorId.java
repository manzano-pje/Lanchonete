package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.dtos.RetornoProdutoDto;

public interface BuscarProdutoPorId {

    RetornoProdutoDto buscarProdutoPorId(Integer id);
}
