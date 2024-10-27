package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Fornecedor;

import java.util.Optional;

public interface BuscarFornecedorPorCnpj {
    Fornecedor buscarFornecedorPorCnpj(String cnpj);
}
