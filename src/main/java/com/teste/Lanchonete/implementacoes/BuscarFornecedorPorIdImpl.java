package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.BuscarFornecedorPorId;
import com.teste.Lanchonete.repositories.FornecedoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarFornecedorPorIdImpl implements BuscarFornecedorPorId {
    private final FornecedoreRepository fornecedoreRepository;

    @Override
    public Fornecedor buscarFornecedorPorId(Integer id) {
        return fornecedoreRepository.findById(id).
                orElseThrow(NaoExistemFornecedoresException::new);
    }
}
