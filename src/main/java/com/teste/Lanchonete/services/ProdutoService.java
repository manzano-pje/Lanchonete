package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.interfaces.*;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import com.teste.Lanchonete.repositories.FornecedoreRepository;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class ProdutoService {

    private final BuscarFornecedorPorId buscarFornecedorPorId;
    private final FornecedoreRepository fornecedoreRepository;
    private final BuscarCategoriaPorId buscarCategoriaPorId;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final BuscarProdutoPorNome buscarProdutoPorNome;
    private final BuscarTodosProdutos buscarTodosProdutos;
    private final BuscarProdutoPorId buscarProdutoPorId;
    private final ModelMapper mapper;
  
    public ProdutoDto criarProdutos(ProdutoDto produtoDto){

        buscarProdutoPorNome.buscarProdutoPorNome(produtoDto.getProduto());
        Produto produto = mapper.map(produtoDto, Produto.class);
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produtoDto.getFornecedor());
        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor);
        produtoRepository.save(produto);
        return mapper.map(produto, ProdutoDto.class);
    }

    public List<ProdutoDto> listarTodosProdutos(){
        List<Produto> produtos = buscarTodosProdutos.listarTodosProdutos();
        return produtos.
                stream().
                map(produto -> {
                    Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produto.getCategoria().getIdCategoria());
                    Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produto.getFornecedor().getIdFornecedor());
                    return new ProdutoDto(produto, categoria, fornecedor);
                }).
                collect(Collectors.toList());
    }

    public ProdutoDto listarUmProduto(Integer id){
        return buscarProdutoPorId.buscarProdutoPorId(id);
    }

    public void alterarUmProduto(Integer id, ProdutoDto produtoDto){
        ProdutoDto produtos = buscarProdutoPorId.buscarProdutoPorId(id);
        Produto produto = mapper.map(produtos, Produto.class);
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produtoDto.getFornecedor());
        produto.atualizar(produtoDto, categoria, fornecedor);
        produtoRepository.save(produto);
    }
}


