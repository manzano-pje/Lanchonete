package com.teste.Lanchonete.interfaces;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.entities.Categorias;

public interface VerificarCategoria {
    void validarCategoriaExistente(CategoriasDto categoriasDto);
    Categorias buscarCategoriaPorId(Integer idCategoria);
}
