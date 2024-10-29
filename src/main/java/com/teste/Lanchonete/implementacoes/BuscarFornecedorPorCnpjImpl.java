package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.BuscarFornecedorPorCnpj;
import com.teste.Lanchonete.repositories.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarFornecedorPorCnpjImpl implements BuscarFornecedorPorCnpj {
    private final FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj).
                orElseThrow(NaoExistemFornecedoresException::new);
    }
}
