package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final CategoriasRepository categoriasRepository;
    private final FornecedoresRepository fornecedoresRepository;
    private final VerificacaoCriaProdutos verificacaoCriaProdutos;
    private final VerificarFornecedor verificarFornecedor;
    private final VerificarCategoria verificarCategoria;
    private final ModelMapper mapper;
  
    public ProdutosDto criarProdutos(ProdutosDto produtosDto){

        verificacaoCriaProdutos.verificar(produtosDto);
        Categorias categorias = verificarCategoria.verificar(produtosDto);
        Fornecedores fornecedores = verificarFornecedor.verificar(produtosDto);
        Produtos produtos = mapper.map(produtosDto, Produtos.class);

        produtos.setCategorias(categorias);
        produtos.setFornecedores(fornecedores);
        produtosRepository.save(produtos);
        return mapper.map(produtos, ProdutosDto.class);
    }

}


