package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VerificarFornecedorImpl implements VerificarFornecedor {
    private final FornecedoresRepository fornecedoresRepository;

    @Override
    public Fornecedores verificarFornecedorPorId(Integer id) {
       return fornecedoresRepository.findById(id).
               orElseThrow(NaoExistemFornecedoresException::new);
    }

    @Override
    public List<Fornecedores> buscarTodosFornecedores() {
        List<Fornecedores> fornecedores = fornecedoresRepository.findAll();
        if(fornecedores.isEmpty()){
            throw new NaoExistemFornecedoresException();
        }
        return fornecedores;
    }

}
