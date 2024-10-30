package com.teste.Lanchonete.services;

import com.teste.Lanchonete.configuracoes.FormatarTexto;
import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.dtos.RetornoProdutoDto;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import com.teste.Lanchonete.implementacoes.*;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import com.teste.Lanchonete.repositories.FornecedorRepository;
import com.teste.Lanchonete.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.teste.Lanchonete.configuracoes.FormatarTexto.formatarString;

@Data
@AllArgsConstructor
@Service
public class ProdutoService {

    private final BuscarFornecedorPorCnpjImpl buscarFornecedorPorCnpj;
    private final BuscarFornecedorPorIdImpl buscarFornecedorPorId;
    private final FornecedorRepository fornecedorRepository;
    private final BuscarCategoriaPorIdImpl buscarCategoriaPorId;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final BuscarProdutoPorNomeImpl buscarProdutoPorNome;
    private final BuscarTodosProdutosImpl buscarTodosProdutos;
    private final BuscarProdutoPorIdImpl buscarProdutoPorId;
    private final ModelMapper mapper;
    private final FormatarTexto formatarTexto;
  
    public void criarProdutos(ProdutoDto produtoDto){
        buscarProdutoPorNome.buscarProdutoPorNome(produtoDto.getProduto());
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produtoDto.getFornecedor());

        Produto produto = mapper.map(produtoDto, Produto.class);
        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor);
        produto.setDataCadastro(new Date());
        produto.setProduto(formatarString(produtoDto.getProduto()));
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
        Produto produto = mapper.map(produtos, Produto.class);
        Categoria categoria = buscarCategoriaPorId.buscarCategoriaPorId(produtoDto.getCategoria());
        Fornecedor fornecedor = buscarFornecedorPorId.buscarFornecedorPorId(produtoDto.getFornecedor());

        produto.atualizar(produtoDto, categoria, fornecedor);
        produto.setId(id);
        produto.setProduto(formatarString(produtoDto.getProduto()));
        produtoRepository.save(produto);
    }

    public  void excluirUmProduto(Integer id){
        buscarProdutoPorId.buscarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}


