package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriaDto;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.implementacoes.BuscarCategoriaPorIdImpl;
import com.teste.Lanchonete.implementacoes.BuscarCategoriaPorNomeImpl;
import com.teste.Lanchonete.interfaces.BuscarCategoriaPorId;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper mapper;
    private final BuscarCategoriaPorIdImpl buscarCategoriaPorId;
    private final BuscarCategoriaPorNomeImpl buscarCategoriaPorNome;

    public CategoriaDto criarCategorias(CategoriaDto categoriaDto) {
        buscarCategoriaPorNome.buscarCategoriaPorNome(categoriaDto.getNomeCategoria());
        Categoria categoria = mapper.map(categoriaDto, Categoria.class);
        categoriaRepository.save(categoria);
        return mapper.map(categoria, CategoriaDto.class);
    }

    public List<CategoriaDto> listarCategorias() {
        try {
            List<Categoria> categoriaList = categoriaRepository.findAll();
            if (categoriaList.isEmpty()) {
                throw new NaoExitemCategoriasException();
            }
            return categoriaList.
                    stream().
                    map(CategoriaDto::new).
                    collect(Collectors.toList());
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public CategoriaDto listarUmaCategoria(Integer idCategorias){
       Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(idCategorias);
       return mapper.map(categoria, CategoriaDto.class);
    }

    public void atualizarCategoria(Integer id, CategoriaDto categoriaDto){
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(id);
        categoria.atualizar(categoriaDto);
        categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Integer idCategorias){
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(idCategorias);
        categoriaRepository.delete(categoria);
    }
}