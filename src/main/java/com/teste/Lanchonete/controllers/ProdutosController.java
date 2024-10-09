package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.services.ProdutosService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("v1/produtos")
public class ProdutosController {

    private final ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<Object> criarProdutos(@RequestBody @Valid ProdutosDto produtosDto){
        ProdutosDto retorno = produtosService.criarProdutos(produtosDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/produtos}").
                buildAndExpand(retorno.getNome()).toUri();
        return ResponseEntity.created(uri).body("Produto " + retorno.getNome() + " cadastrado com sucesso!");
    }

}
