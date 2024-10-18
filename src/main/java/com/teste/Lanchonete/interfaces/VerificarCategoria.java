package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.entities.Categoria;

/**
 *  verificar categorias
 *
 */
public interface VerificarCategoria {

    void buscarCategoriaPorNome(String nome);
    Categoria buscarCategoriaPorId(Integer id);
}
