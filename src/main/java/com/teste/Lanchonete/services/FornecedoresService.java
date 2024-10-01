package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.FornecedoresDto;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.FornecedorJaExisteException;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
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
}
