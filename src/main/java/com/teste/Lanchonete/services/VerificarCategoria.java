package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;

public interface VerificarCategoria {
    Categorias verificar(ProdutosDto produtosDto);
}
