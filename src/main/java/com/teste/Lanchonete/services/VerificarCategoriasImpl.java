package com.teste.Lanchonete.services;

import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.CategoriaJaExisteException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.interfaces.VerificarCategorias;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  verificar categorias impl
 *
 */
@AllArgsConstructor
@Service
public class VerificarCategoriasImpl implements VerificarCategorias {

    private final CategoriasRepository categoriasRepository;

    @Override
    public void buscarCategoriaPorNome(String nome) {
        categoriasRepository.findBynomeCategoria(nome).
                ifPresent(categoria -> {
                    throw new  CategoriaJaExisteException();
                });
    }

    @Override
    public Categorias buscarCategoriaPorId(Integer idCategoria) {
        return categoriasRepository.findById(idCategoria).
                orElseThrow(NaoExitemCategoriasException::new);
    }

}
