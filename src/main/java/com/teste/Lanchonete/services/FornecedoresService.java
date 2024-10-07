package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.FornecedoresDto;
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
    private final FormatarTexto formatarTexto;

    public FornecedoresDto criarFornecedores(FornecedoresDto fornecedoresDto){
        try{
            String fornecedorFormatado = FormatarTexto.formatarTexto(fornecedoresDto.getNome());
            Optional<Fornecedores> fornecedoresOptional = fornecedoresRepository.findByCnpj(fornecedoresDto.getCnpj());
            if(fornecedoresOptional.isPresent()){
                throw new FornecedorJaExisteException();
            }
            fornecedoresDto.setNome(fornecedorFormatado);
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
            Fornecedores fornecedores = fornecedoresRepository.findByNome(fornecedor).
                    orElseThrow(NaoExistemFornecedoresException::new);
            return mapper.map(fornecedores,FornecedoresDto.class);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public void alterarFornecedor(String fornecedor, FornecedoresDto fornecedoresDto){
        try {
            Fornecedores dadosFornecedor = fornecedoresRepository.findByNome(fornecedor).
                    orElseThrow(NaoExistemFornecedoresException::new);

           dadosFornecedor.atualizar(fornecedoresDto);
            fornecedoresRepository.save(dadosFornecedor);
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }

    public void excluirFornecedor(String fornecedor){
        try {
            Fornecedores fornecedores = fornecedoresRepository.findByNome(fornecedor).
                    orElseThrow(NaoExistemFornecedoresException::new);

            fornecedoresRepository.deleteById(fornecedores.getIdFornecedor());
        }catch (DataAccessException err){
            throw new ErroDoServidorException();
        }
    }
}
