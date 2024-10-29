package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.dtos.RetornoProdutoDto;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.exceptions.DataInvalidaException;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.implementacoes.*;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import com.teste.Lanchonete.repositories.FornecedoreRepository;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class ProdutoService {

    private final BuscarFornecedorPorCnpjImpl buscarFornecedorPorId;
    private final FornecedoreRepository fornecedoreRepository;
    private final BuscarCategoriaPorIdImpl buscarCategoriaPorId;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final BuscarProdutoPorNomeImpl buscarProdutoPorNome;
    private final BuscarTodosProdutosImpl buscarTodosProdutos;
    private final BuscarProdutoPorIdImpl buscarProdutoPorId;
    private final ModelMapper mapper;
  
    public void criarProdutos(ProdutoDto produtoDto){
        buscarProdutoPorNome.buscarProdutoPorNome(produtoDto.getProduto());
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Optional<Fornecedor> fornecedor = fornecedoreRepository.findById(produtoDto.getFornecedor());
        Date data = new Date();

        Produto produto = mapper.map(produtoDto, Produto.class);
        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor.get());
        produto.setDataCadastro(data);
        produtoRepository.save(produto);
    }

    public List<RetornoProdutoDto> listarTodosProdutos(){
        List<Produto> produtos = buscarTodosProdutos.listarTodosProdutos();
        return produtos.
                stream().
                map(RetornoProdutoDto::new).
                collect(Collectors.toList());
    }

    public RetornoProdutoDto listarUmProduto(Integer id){
        return buscarProdutoPorId.buscarProdutoPorId(id);
    }

    public void alterarUmProduto(Integer id, ProdutoDto produtoDto){
        RetornoProdutoDto produtos = buscarProdutoPorId.buscarProdutoPorId(id);

        if((produtos.getQuantidade() + produtoDto.getQuantidade() > produtos.getEstoqueMinimo())){
            throw new DataInvalidaException();
        }

        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorCnpj(produtoDto.getFornecedor().toString());

        Produto produto = mapper.map(produtos, Produto.class);

        produto.atualizar(produtoDto, categoria, fornecedor);
        produto.setId(id);
        produtoRepository.save(produto);
    }
}


