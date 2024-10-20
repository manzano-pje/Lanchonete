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
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produtoDto.getFornecedor());
        Produto produto = mapper.map(produtoDto, Produto.class);

        produto.setCategoria(categoria.getIdCategoria());
        produto.setFornecedor(fornecedor.getIdFornecedor());
        produtoRepository.save(produto);
        return mapper.map(produto, ProdutoDto.class);
    }

    public List<ProdutoDto> listarTodosProdutos(){
        return buscarTodosProdutos.listarTodosProdutos().
                stream().
                map(ProdutoDto::new).
                collect(Collectors.toList());
    }

    public ProdutoDto listarUmProduto(Integer id){
            return buscarProdutoPorId.buscarProdutoPorId(id);
    }

    public void alterarUmProduto(Integer id, ProdutoDto produtoDto){
        ProdutoDto nomeProdutos = buscarProdutoPorId.buscarProdutoPorId(id);
        Produto produto = mapper.map(nomeProdutos, Produto.class);
        produto.atualizar(produtoDto);
        produtoRepository.save(produto);
    }
}


