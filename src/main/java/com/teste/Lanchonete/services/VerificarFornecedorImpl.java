package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VerificarFornecedorImpl implements VerificarFornecedor {
    private final FornecedoresRepository fornecedoresRepository;

    @Override
    public Fornecedores verificar(ProdutosDto produtosDto) {
       return fornecedoresRepository.findById(produtosDto.getIdFornecedor()).
               orElseThrow(NaoExistemFornecedoresException::new);
    }
}
