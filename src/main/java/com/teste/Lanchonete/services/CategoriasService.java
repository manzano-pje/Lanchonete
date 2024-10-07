package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.exceptions.CategoriaJaExisteException;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private final ModelMapper mapper;

    public CategoriasDto criarCategorias(CategoriasDto categoriasDto) {
        try {
            Optional<Categorias> categoriasOptional = categoriasRepository.
                    findBynomeCategoria(categoriasDto.getNomeCategoria());
            if (categoriasOptional.isPresent()) {
                throw new CategoriaJaExisteException();
            }
            Categorias categoria = mapper.map(categoriasDto, Categorias.class);
            categoriasRepository.save(categoria);
            return mapper.map(categoria, CategoriasDto.class);
        } catch (DataAccessException err) {
            throw new ErroDoServidorException();
        }
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

    public CategoriasDto listarUmaCategoria(String nome){
        try{
            Categorias categoriasOptional = categoriasRepository.findBynomeCategoria(nome).
                    orElseThrow(NaoExitemCategoriasException::new);
            return mapper.map(categoriasOptional, CategoriasDto.class);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public void atualizarCategoria(String nome, CategoriasDto categoriasDto){
        try{
             Categorias categoria = categoriasRepository.findBynomeCategoria(nome).
                    orElseThrow(NaoExitemCategoriasException::new);
            categoria.atualizar(categoriasDto);
            categoriasRepository.save(categoria);

        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public void excluirCategoria(String nome){
        try{
            Categorias categoriasOptional = categoriasRepository.findBynomeCategoria(nome).
                orElseThrow(NaoExitemCategoriasException::new);
            categoriasRepository.delete(categoriasOptional);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }
}