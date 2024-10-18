package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
import com.teste.Lanchonete.repositories.FornecedoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VerificarFornecedorImpl implements VerificarFornecedor {
    private final FornecedoreRepository fornecedoreRepository;

    @Override
    public Fornecedor verificarFornecedorPorId(Integer id) {
        return fornecedoreRepository.findById(id).
                orElseThrow(NaoExistemFornecedoresException::new);
    }

    @Override
    public List<Fornecedor> buscarTodosFornecedores() {
        List<Fornecedor> fornecedores = fornecedoreRepository.findAll();
        if(fornecedores.isEmpty()){
            throw new NaoExistemFornecedoresException();
        }
        return fornecedores;
    }


}
