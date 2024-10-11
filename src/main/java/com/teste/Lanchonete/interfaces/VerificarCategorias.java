package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Categorias;

/**
 *  verificar categorias
 *
 */
public interface VerificarCategorias {

    void buscarCategoriaPorNome(String nome);
    Categorias buscarCategoriaPorId(Integer id);
}
