package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.interfaces.VerificarProdutoPorNome;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificarProdutoPorNomeImpl implements VerificarProdutoPorNome {
    private final ProdutoRepository produtoRepository;

    @Override
    public void verificarProdutoPorNome(String produto) {
        Optional<Produto> produtosOptional = produtoRepository.findByProduto(produto);
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }
}
