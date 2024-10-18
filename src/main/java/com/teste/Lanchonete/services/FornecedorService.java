package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.FornecedorDto;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
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
    private final VerificarFornecedor verificarFornecedor;

    public FornecedorDto criarFornecedores(FornecedorDto fornecedorDto){
       verificarFornecedor.verificarFornecedorPorId(fornecedorDto.getIdFornecedor());
       Fornecedor fornecedor = mapper.map(fornecedorDto, Fornecedor.class);
       fornecedoreRepository.save(fornecedor);
       return mapper.map(fornecedor, FornecedorDto.class);
    }

    public List<FornecedorDto> listarTodosFornecedores(){
            return verificarFornecedor.buscarTodosFornecedores().
                    stream().
                    map(FornecedorDto::new).
                    collect(Collectors.toList());
    }

    public FornecedorDto listarUmFornecedor(Integer id){
            Fornecedor fornecedor = verificarFornecedor.verificarFornecedorPorId(id);
            return mapper.map(fornecedor, FornecedorDto.class);
    }

    public void alterarFornecedor(Integer id, FornecedorDto fornecedorDto){
        Fornecedor dadosFornecedor = verificarFornecedor.verificarFornecedorPorId(id);
        dadosFornecedor.atualizar(fornecedorDto);
        fornecedoreRepository.save(dadosFornecedor);
    }

    public void excluirFornecedor(Integer id){
        verificarFornecedor.verificarFornecedorPorId(id);
        fornecedoreRepository.deleteById(id);
    }
}
