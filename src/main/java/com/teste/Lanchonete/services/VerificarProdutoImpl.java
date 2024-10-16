package com.teste.Lanchonete.services;

import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.exceptions.NaoExistemProdutosCadastradosException;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.exceptions.ProdutoNaoCadastradoException;
import com.teste.Lanchonete.interfaces.VerificacarProdutos;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificarProdutoImpl implements VerificacarProdutos {

    private final ProdutosRepository produtosRepository;

    @Override
    public void verificarProdutoPorNome(String produto) {
        Optional<Produtos> produtosOptional = produtosRepository.findByProduto(produto);
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }

    @Override
    public List<Produtos> listarTodosProdutos(){
        List<Produtos> listaProdutos = produtosRepository.findAll();
        if(listaProdutos.isEmpty()){
            throw new NaoExistemProdutosCadastradosException();
        }
        return listaProdutos;
    }

    @Override
    public Produtos listarProdutoPorId(Integer id) {
        return produtosRepository.findById(id).
                orElseThrow(ProdutoNaoCadastradoException::new);
    }



}
