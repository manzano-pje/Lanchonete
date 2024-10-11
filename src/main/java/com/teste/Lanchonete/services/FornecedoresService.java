package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.FornecedoresDto;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.*;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
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
    private final VerificarFornecedor verificarFornecedor;

    public FornecedoresDto criarFornecedores(FornecedoresDto fornecedoresDto){
       verificarFornecedor.verificarFornecedorPorId(fornecedoresDto.getIdFornecedor());
       Fornecedores fornecedor = mapper.map(fornecedoresDto, Fornecedores.class);
       fornecedoresRepository.save(fornecedor);
       return mapper.map(fornecedor, FornecedoresDto.class);
    }

    public List<FornecedoresDto> listarTodosFornecedores(){
            return verificarFornecedor.buscarTodosFornecedores().
                    stream().
                    map(FornecedoresDto::new).
                    collect(Collectors.toList());
    }

    public FornecedoresDto listarUmFornecedor(Integer id){
            Fornecedores fornecedor = verificarFornecedor.verificarFornecedorPorId(id);
            return mapper.map(fornecedor,FornecedoresDto.class);
    }

    public void alterarFornecedor(FornecedoresDto fornecedorDto){
        Fornecedores dadosFornecedor = verificarFornecedor.verificarFornecedorPorId(fornecedorDto.getIdFornecedor());
        dadosFornecedor.atualizar(fornecedorDto);
        fornecedoresRepository.save(dadosFornecedor);
    }

    public void excluirFornecedor(Integer id){
        verificarFornecedor.verificarFornecedorPorId(id);
        fornecedoresRepository.deleteById(id);
    }
}
