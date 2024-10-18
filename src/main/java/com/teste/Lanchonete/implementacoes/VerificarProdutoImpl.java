package com.teste.Lanchonete.implementacoes;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.NaoExistemProdutosCadastradosException;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.exceptions.ProdutoNaoCadastradoException;
import com.teste.Lanchonete.interfaces.VerificacarProduto;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificarProdutoImpl implements VerificacarProduto {

    private final ProdutoRepository produtoRepository;

    @Override
    public void verificarProdutoPorNome(String produto) {
        Optional<Produto> produtosOptional = produtoRepository.findByProduto(produto);
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
    }

    @Override
    public List<Produto> listarTodosProdutos(){
        List<Produto> listaProdutos = produtoRepository.findAll();
        if(listaProdutos.isEmpty()){
            throw new NaoExistemProdutosCadastradosException();
        }
        return listaProdutos;
    }

    @Override
    public ProdutoDto listarProdutoPorId(Integer id) {
        Produto produto = produtoRepository.findById(id).
                orElseThrow(ProdutoNaoCadastradoException::new);
        return new ProdutoDto();
    }
}
