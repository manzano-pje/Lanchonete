package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.interfaces.VerificacarProdutos;
import com.teste.Lanchonete.interfaces.VerificarCategorias;
import com.teste.Lanchonete.interfaces.VerificarFornecedor;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final CategoriasRepository categoriasRepository;
    private final FornecedoresRepository fornecedoresRepository;
    private final VerificacarProdutos verificacarProdutos;
    private final VerificarFornecedor verificarFornecedor;
    private final VerificarCategorias verificarCategorias;
    private final ModelMapper mapper;
  
    public ProdutosDto criarProdutos(ProdutosDto produtosDto){

        verificacarProdutos.verificarProdutoPorNome(produtosDto.getProduto());
        Categorias categorias = verificarCategorias.buscarCategoriaPorId(produtosDto.getCategoria());
        Fornecedores fornecedores = verificarFornecedor.verificarFornecedorPorId(produtosDto.getFornecedor());
        Produtos produtos = mapper.map(produtosDto, Produtos.class);

        produtos.setCategorias(categorias);
        produtos.setFornecedores(fornecedores);
        produtosRepository.save(produtos);
        return mapper.map(produtos, ProdutosDto.class);
    }

    public List<ProdutosDto> listarTodosProdutos(){
        return verificacarProdutos.listarTodosProdutos().
                stream().
                map(ProdutosDto::new).
                collect(Collectors.toList());
    }

    public ProdutosDto listarUmProduto(Integer id){
            return mapper.map(verificacarProdutos.listarProdutoPorId(id),ProdutosDto.class);
    }
}


