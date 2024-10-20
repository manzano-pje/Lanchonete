package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.exceptions.CategoriaJaExisteException;
import com.teste.Lanchonete.interfaces.BuscarCategoriaPorNome;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarCategoriaPorNomeImpl implements BuscarCategoriaPorNome{

    private final CategoriaRepository categoriaRepository;

    @Override
    public void buscarCategoriaPorNome(String nome) {
        categoriaRepository.findBynomeCategoria(nome).
                ifPresent(categoria -> {
                    throw new CategoriaJaExisteException();
                });
    }
}
