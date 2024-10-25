package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.FornecedorDto;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.FornecedorJaExisteException;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.implementacoes.BuscarFornecedorPorCnpjImpl;
import com.teste.Lanchonete.implementacoes.BuscarTodosFornecedoresImpl;
import com.teste.Lanchonete.repositories.FornecedoreRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FornecedorService {

    private final FornecedoreRepository fornecedoreRepository;
    private final ModelMapper mapper;
    private final FormatarTexto formatarTexto;
    private final BuscarFornecedorPorCnpjImpl buscarFornecedorPorCnpj;
    private final BuscarTodosFornecedoresImpl buscarTodosFornecedores;

    public FornecedorDto criarFornecedores(FornecedorDto fornecedorDto){
        Optional<Fornecedor> optionalFornecedor = fornecedoreRepository.findByCnpj(fornecedorDto.getCnpj());
        if(optionalFornecedor.isPresent()){
            throw new FornecedorJaExisteException();
        }
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

    public FornecedorDto listarUmFornecedor(String cnpj){
            Fornecedor fornecedor = buscarFornecedorPorCnpj.buscarFornecedorPorCnpj(cnpj);
            return mapper.map(fornecedor, FornecedorDto.class);
    }

    public void alterarFornecedor(String cnpj, FornecedorDto fornecedorDto){
        Fornecedor dadosFornecedor = buscarFornecedorPorCnpj.buscarFornecedorPorCnpj(cnpj);
        dadosFornecedor.atualizar(fornecedorDto);
        fornecedoreRepository.save(dadosFornecedor);
    }

    public void excluirFornecedor(String cnpj){
        fornecedoreRepository.deleteById(buscarFornecedorPorCnpj.buscarFornecedorPorCnpj(cnpj).getIdFornecedor());
    }
}
