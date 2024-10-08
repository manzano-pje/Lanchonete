package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
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
import org.springframework.http.ResponseEntity;
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

        Optional<Produtos> produtos = produtosRepository.findById(produtosDto.getIdProduto());
        if(produtos.isPresent()){
            throw new ProdutoJaExisteException();
        }
        /* verifica a existência da categoria */
        Boolean categoria = categoriasRepository.findByCategoria(produtosDto.getCategoria());
        if(!categoria){
            throw new NaoExitemCategoriasException();
        }

        /* verficia a existência do fornecedor */
        Boolean fornecedor = fornecedoresRepository.findByFornecedor(produtosDto.getFornecedor());
        if(!fornecedor){
            throw new NaoExistemFornecedoresException();
        }


        return null;
    }


}
