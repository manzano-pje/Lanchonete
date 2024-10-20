package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.NaoExistemProdutosCadastradosException;
import com.teste.Lanchonete.interfaces.BuscarTodosProdutos;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuscarTodosProdutosImpl implements BuscarTodosProdutos {

    private final ProdutoRepository produtoRepository;
    @Override
    public List<Produto> listarTodosProdutos(){
        List<Produto> listaProdutos = produtoRepository.findAll();
        if(listaProdutos.isEmpty()){
            throw new NaoExistemProdutosCadastradosException();
        }
        return listaProdutos;
    }
}
