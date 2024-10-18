package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.interfaces.VerificacarProduto;
import com.teste.Lanchonete.interfaces.VerificarCategoria;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import com.teste.Lanchonete.repositories.FornecedoreRepository;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    @Autowired
    private final CategoriaRepository categoriaRepository;
    private final FornecedoreRepository fornecedoreRepository;
    private final VerificacarProduto verificacarProduto;
    private final VerificarFornecedor verificarFornecedor;
    private final VerificarCategoria verificarCategoria;
    private final ModelMapper mapper;
  
    public ProdutoDto criarProdutos(ProdutoDto produtoDto){

        verificacarProduto.verificarProdutoPorNome(produtoDto.getProduto());
        Categoria categoria = verificarCategoria.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = verificarFornecedor.verificarFornecedorPorId(produtoDto.getFornecedor());
        Produto produto = mapper.map(produtoDto, Produto.class);

        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor);
        produtoRepository.save(produto);
        return mapper.map(produto, ProdutoDto.class);
    }

    public List<ProdutoDto> listarTodosProdutos(){
        return verificacarProduto.listarTodosProdutos().
                stream().
                map(ProdutoDto::new).
                collect(Collectors.toList());
    }

    public ProdutoDto listarUmProduto(Integer id){
            return verificacarProduto.listarProdutoPorId(id);

    }

    public void alterarUmProduto(Integer id, ProdutoDto produtoDto){
        ProdutoDto nomeProdutos = verificacarProduto.listarProdutoPorId(id);
        Produto produto = mapper.map(nomeProdutos, Produto.class);
        produto.atualizar(produtoDto);
        produtoRepository.save(produto);
    }


}


