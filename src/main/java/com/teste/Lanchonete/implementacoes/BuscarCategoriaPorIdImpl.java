package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.interfaces.BuscarCategoriaPorId;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  verificar categorias impl
 *
 */
@AllArgsConstructor
@Service
public class BuscarCategoriaPorIdImpl implements BuscarCategoriaPorId{

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria buscarCategoriaPorId(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).
                orElseThrow(NaoExitemCategoriasException::new);
    }
}
