package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;

public interface VerificarCategoria {
    Categorias existeCategoria(ProdutosDto produtosDto);
    void existeCategoria(CategoriasDto categoriasDto);
    Categorias verificaLista(Integer idCategoria);
}
