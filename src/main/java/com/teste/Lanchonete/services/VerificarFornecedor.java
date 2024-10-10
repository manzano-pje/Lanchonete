package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Fornecedores;

public interface VerificarFornecedor {
    Fornecedores verificar(ProdutosDto produtosDto);
}
