package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.interfaces.VerificarCategoria;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private final ModelMapper mapper;
    private final VerificarCategoria verificarCategoria;

    public CategoriasDto criarCategorias(CategoriasDto categoriasDto) {

        verificarCategoria.existeCategoria(categoriasDto);
        Categorias categoria = mapper.map(categoriasDto, Categorias.class);
        categoriasRepository.save(categoria);
        return mapper.map(categoria, CategoriasDto.class);
    }

    public List<CategoriasDto> listarCategorias() {
        try {
            List<Categorias> categoriasList = categoriasRepository.findAll();
            if (categoriasList.isEmpty()) {
                throw new NaoExitemCategoriasException();
            }

            return categoriasList.
                    stream().
                    map(CategoriasDto::new).
                    collect(Collectors.toList());
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public CategoriasDto listarUmaCategoria(Integer idCategorias){
       Categorias categorias = verificarCategoria.verificaLista(idCategorias);
       return mapper.map(categorias, CategoriasDto.class);
    }

    public void atualizarCategoria(Integer id, CategoriasDto categoriasDto){

        Categorias categoria = verificarCategoria.verificaLista(id);
        categoria.atualizar(categoriasDto);
        categoriasRepository.save(categoria);
    }

    public void excluirCategoria(Integer idCategorias){
        Categorias categoria = verificarCategoria.verificaLista(idCategorias);
        categoriasRepository.delete(categoria);
    }
}