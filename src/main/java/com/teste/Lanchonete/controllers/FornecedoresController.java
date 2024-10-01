package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.FornecedoresDto;
import com.teste.Lanchonete.services.FornecedoresService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"v1/fornecedores"})
public class FornecedoresController {

    private FornecedoresService fornecedoresService;

    @PostMapping
    public ResponseEntity<Object> criarFornecedores(@RequestBody @Valid FornecedoresDto fornecedoresDto) {
        FornecedoresDto fornecedores = fornecedoresService.criarFornecedores(fornecedoresDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/cnpj}").
                buildAndExpand(fornecedores.getCnpj()).toUri();
        return ResponseEntity.created(uri).body("Fornecedor cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresDto>> listarTodosFornecedores(){
        List<FornecedoresDto> fornecedores = fornecedoresService.listarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }
}
