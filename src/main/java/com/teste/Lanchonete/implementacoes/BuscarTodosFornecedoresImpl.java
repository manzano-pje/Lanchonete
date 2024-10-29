package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.BuscarTodosFornecedores;
import com.teste.Lanchonete.repositories.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BuscarTodosFornecedoresImpl implements BuscarTodosFornecedores {
    private final FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> buscarTodosFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        if(fornecedores.isEmpty()){
            throw new NaoExistemFornecedoresException();
        }
        return fornecedores;
    }
}
