package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.services.ProdutosService;
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
public class ProdutosController {

    private final ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<Object> criarProdutos(@RequestBody @Valid ProdutosDto produtosDto){
        produtosService.criarProdutos(produtosDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
    }

    @GetMapping
    public List<ProdutosDto> listarTodosProdutos(){
        List<ProdutosDto> listaProdutosDto = produtosService.listarTodosProdutos();
        return listaProdutosDto;

    }

    @GetMapping("/{id}")
    public ProdutosDto listarUmProduto(@PathVariable Integer id){
        return produtosService.listarUmProduto(id);
    }
}
