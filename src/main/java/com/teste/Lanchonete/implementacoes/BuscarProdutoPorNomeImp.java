package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.interfaces.BuscarProdutoPorNome;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarProdutoPorNomeImp implements BuscarProdutoPorNome {
    private final ProdutoRepository produtoRepository;

    @Override
    public void buscarProdutoPorNome(String produto) {
        Optional<Produto> produtosOptional = produtoRepository.findByProduto(produto);
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }
}
