package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.exceptions.ProdutoJaExisteException;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final CategoriasRepository categoriasRepository;
    private final FornecedoresRepository fornecedoresRepository;
    private final ModelMapper mapper;

    public ProdutosDto criarProdutos(ProdutosDto produtosDto){
        Optional<Produtos> produtosOptional = produtosRepository.findById(produtosDto.getIdProduto());
        if(produtosOptional.isPresent()){
            throw new ProdutoJaExisteException();
        }
        /* verifica a existência da categoria */
        Optional<Categorias> categoria = categoriasRepository.findById(produtosDto.getIdCategoria());
        if(categoria.isEmpty()){
            throw new NaoExitemCategoriasException();
        }

        /* verficia a existência do fornecedor */
        Optional<Fornecedores> fornecedor = fornecedoresRepository.findById(produtosDto.getIdFornecedor());
        if(fornecedor.isEmpty()){
            throw new NaoExistemFornecedoresException();
        }

        produtosDto.setIdCategoria(categoria.get().getIdCategoria());
        produtosDto.setIdFornecedor(fornecedor.get().getIdFornecedor());
        Produtos produtos = mapper.map(produtosDto, Produtos.class);

        produtosRepository.save(produtos);
        return mapper.map(produtos, ProdutosDto.class);
    }


}
