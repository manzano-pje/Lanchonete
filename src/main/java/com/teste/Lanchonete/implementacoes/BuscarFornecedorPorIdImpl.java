package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.BuscarFornecedorPorId;
import com.teste.Lanchonete.repositories.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarFornecedorPorIdImpl implements BuscarFornecedorPorId {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor buscarFornecedorPorId(Integer idFornecedor){
        return fornecedorRepository.findById(idFornecedor).
                orElseThrow(NaoExistemFornecedoresException::new);
    }
}