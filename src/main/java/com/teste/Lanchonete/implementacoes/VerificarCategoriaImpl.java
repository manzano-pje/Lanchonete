package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.exceptions.CategoriaJaExisteException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.interfaces.VerificarCategoria;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  verificar categorias impl
 *
 */
@AllArgsConstructor
@Service
public class VerificarCategoriaImpl implements VerificarCategoria {

    private final CategoriaRepository categoriaRepository;

    @Override
    public void buscarCategoriaPorNome(String nome) {
        categoriaRepository.findBynomeCategoria(nome).
                ifPresent(categoria -> {
                    throw new  CategoriaJaExisteException();
                });
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).
                orElseThrow(NaoExitemCategoriasException::new);
    }

}
