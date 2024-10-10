package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.interfaces.VerificacaoCriaProdutos;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificarProdutoExistente implements VerificacaoCriaProdutos {

    private final ProdutosRepository produtosRepository;

    @Override
    public void verificar(ProdutosDto produtosDto) {
        Optional<Produtos> produtosOptional = produtosRepository.findByNomeProduto(produtosDto.getNomeProduto());
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }
}
