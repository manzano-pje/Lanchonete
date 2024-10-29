package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.ProdutoDto;
import com.teste.Lanchonete.dtos.RetornoProdutoDto;
import com.teste.Lanchonete.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> criarProdutos(@RequestBody @Valid ProdutoDto produtoDto){
        produtoService.criarProdutos(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
    }

    @GetMapping
    public List<RetornoProdutoDto> listarTodosProdutos(){
        List<RetornoProdutoDto> listaProdutoDto = produtoService.listarTodosProdutos();
        return listaProdutoDto;

    }

    @GetMapping("/{id}")
    public RetornoProdutoDto listarUmProduto(@PathVariable Integer id){
        return produtoService.listarUmProduto(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> alterarUmProduto(@PathVariable Integer id, @RequestBody @Valid ProdutoDto produtoDto){
        produtoService.alterarUmProduto(id, produtoDto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto alterado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirUmProduto(@PathVariable Integer id){
        produtoService.excluirUmProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucersso!");
    }
}
