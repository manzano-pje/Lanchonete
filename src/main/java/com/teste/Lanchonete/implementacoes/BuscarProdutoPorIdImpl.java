package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.ProdutoNaoCadastradoException;
import com.teste.Lanchonete.interfaces.BuscarProdutoPorId;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarProdutoPorIdImpl implements BuscarProdutoPorId {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoDto buscarProdutoPorId(Integer id) {
        Produto produto = produtoRepository.findById(id).
                orElseThrow(ProdutoNaoCadastradoException::new);
        return new ProdutoDto();
    }
}
