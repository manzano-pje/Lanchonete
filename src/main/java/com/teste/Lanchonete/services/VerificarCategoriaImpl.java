package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VerificarCategoriaImpl implements VerificarCategoria {

    private final CategoriasRepository categoriasRepository;

    @Override
    public Categorias verificar(ProdutosDto produtosDto) {
        return categoriasRepository.findById(produtosDto.getIdCategoria()).
                orElseThrow(NaoExitemCategoriasException::new);
    }
}
