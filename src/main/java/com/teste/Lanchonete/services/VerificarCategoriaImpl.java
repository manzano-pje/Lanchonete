package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.interfaces.VerificarCategoria;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificarCategoriaImpl implements VerificarCategoria {

    private final CategoriasRepository categoriasRepository;

    @Override
    public Categorias existeCategoria(ProdutosDto produtosDto) {
        return categoriasRepository.findById(produtosDto.getIdCategoria()).
                orElseThrow(NaoExitemCategoriasException::new);
    }

    @Override
    public void existeCategoria(CategoriasDto categoriasDto) {
        Optional<Categorias> categoriasOptional = categoriasRepository.findBynomeCategoria(categoriasDto.getNomeCategoria());
        if(categoriasOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }

    @Override
    public Categorias verificaLista(Integer idCategoria) {
        return categoriasRepository.findById(idCategoria).
                orElseThrow(NaoExitemCategoriasException::new);
    }

}
