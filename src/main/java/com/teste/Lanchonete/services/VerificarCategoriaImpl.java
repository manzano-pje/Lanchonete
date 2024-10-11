package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.CategoriaJaExisteException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.interfaces.VerificarCategoria;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VerificarCategoriaImpl implements VerificarCategoria {

    private final CategoriasRepository categoriasRepository;

    @Override
    public void validarCategoriaExistente(CategoriasDto categoriasDto) {
        categoriasRepository.findBynomeCategoria(categoriasDto.getNomeCategoria()).
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
