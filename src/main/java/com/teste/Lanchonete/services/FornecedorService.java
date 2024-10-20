package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.FornecedorDto;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.implementacoes.BuscarFornecedorPorIdImpl;
import com.teste.Lanchonete.implementacoes.BuscarTodosFornecedoresImpl;
import com.teste.Lanchonete.interfaces.BuscarFornecedorPorId;
import com.teste.Lanchonete.repositories.FornecedoreRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FornecedorService {

    private final FornecedoreRepository fornecedoreRepository;
    private final ModelMapper mapper;
    private final FormatarTexto formatarTexto;
    private final BuscarFornecedorPorIdImpl buscarFornecedorPorId;
    private final BuscarTodosFornecedoresImpl buscarTodosFornecedores;

    public FornecedorDto criarFornecedores(FornecedorDto fornecedorDto){
        buscarFornecedorPorId.buscarFornecedorPorId(fornecedorDto.getIdFornecedor());
       Fornecedor fornecedor = mapper.map(fornecedorDto, Fornecedor.class);
       fornecedoreRepository.save(fornecedor);
       return mapper.map(fornecedor, FornecedorDto.class);
    }

    public List<FornecedorDto> listarTodosFornecedores(){
            return buscarTodosFornecedores.buscarTodosFornecedores().
                    stream().
                    map(FornecedorDto::new).
                    collect(Collectors.toList());
    }

    public FornecedorDto listarUmFornecedor(Integer id){
            Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(id);
            return mapper.map(fornecedor, FornecedorDto.class);
    }

    public void alterarFornecedor(Integer id, FornecedorDto fornecedorDto){
        Fornecedor dadosFornecedor = buscarFornecedorPorId.buscarFornecedorPorId(id);
        dadosFornecedor.atualizar(fornecedorDto);
        fornecedoreRepository.save(dadosFornecedor);
    }

    public void excluirFornecedor(Integer id){
        buscarFornecedorPorId.buscarFornecedorPorId(id);
        fornecedoreRepository.deleteById(id);
    }
}
