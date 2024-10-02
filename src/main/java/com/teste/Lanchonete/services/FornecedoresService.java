package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.dtos.FornecedoresDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Empresa;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.*;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FornecedoresService {

    private final FornecedoresRepository fornecedoresRepository;
    private final ModelMapper mapper;

    public FornecedoresDto criarFornecedores(FornecedoresDto fornecedoresDto){
        try{
            Optional<Fornecedores> fornecedoresOptional = fornecedoresRepository.findByCnpj(fornecedoresDto.getCnpj());
            if(fornecedoresOptional.isPresent()){
                throw new FornecedorJaExisteException();
            }
            Fornecedores fornecedores = mapper.map(fornecedoresDto, Fornecedores.class);
            fornecedoresRepository.save(fornecedores);
            return mapper.map(fornecedores, FornecedoresDto.class);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public List<FornecedoresDto> listarTodosFornecedores(){
        try{
            List<Fornecedores> fornecedoresList = fornecedoresRepository.findAll();
            if(fornecedoresList.isEmpty()){
                throw new NaoExistemFornecedoresException();
            }
            return fornecedoresList.
                    stream().
                    map(FornecedoresDto::new).
                    collect(Collectors.toList());
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public FornecedoresDto listarUmFornecedor(String fornecedor){
        try{
            Optional<Fornecedores> fornecedorOptional = fornecedoresRepository.findByNome(fornecedor);
            if(fornecedorOptional.isEmpty()){
                throw new NaoExistemFornecedoresException();
            }
            return mapper.map(fornecedorOptional,FornecedoresDto.class);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }
}
//ublic CategoriasDto listarUmaCategoria(String nome){
//    try{
//        Categorias categoriasOptional = categoriasRepository.findBynomeCategoria(nome).
//                orElseThrow(NaoExitemCategoriasException::new);
//        return mapper.map(categoriasOptional, com.teste.Lanchonete.dtos.CategoriasDto.class);
//    }catch (DataAccessException err){
//        throw new ErroDoServidorException();
//    }
//}