package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.entities.Produtos;
import com.teste.Lanchonete.exceptions.CategoriaNaoExisteExceptions;
import com.teste.Lanchonete.exceptions.NaoExistemFornecedoresException;
import com.teste.Lanchonete.exceptions.NaoExitemCategoriasException;
import com.teste.Lanchonete.exceptions.ProdutoJaCadastradoExceptions;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import com.teste.Lanchonete.repositories.FornecedoresRepository;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
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

//    public ProdutosDto criarProdutos(ProdutosDto produtosDto){
//        try {
//
//            /****** verificação e Fornecedor, Categoria e Produtos ********/
//
//            Categorias categorias = categoriasRepository.findById(produtosDto.getCategoria()).
//                    orElseThrow(CategoriaNaoExisteExceptions::new);
//            Fornecedores fornecedores = fornecedoresRepository.findById(produtosDto.getFornecedor()).
//                    orElseThrow(NaoExistemFornecedoresException::new);
//            Optional<Produtos> produtoOptional = produtosRepository.findByProduto(produtosDto.getNomeProduto());
//            if(produtoOptional.isPresent()){
//                throw new ProdutoJaCadastradoExceptions();
//            }
//
//
//
//
//        }catch (DataAccessException err){
//
//        }
//        return null;
//    }
}
