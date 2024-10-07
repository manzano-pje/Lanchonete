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
        String retorno = "Fornecedor " + fornecedoresDto.getNome() + " cadastrado com sucesso!";
        return ResponseEntity.created(uri).body(retorno);
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresDto>> listarTodosFornecedores(){
        List<FornecedoresDto> fornecedores = fornecedoresService.listarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("/fornecedor/{fornecedor}")
    public ResponseEntity<FornecedoresDto> listarUmFornecedor(@PathVariable @Valid String fornecedor){
        FornecedoresDto fornecedorDto = fornecedoresService.listarUmFornecedor(fornecedor);
        return ResponseEntity.ok(fornecedorDto);
    }

    @PatchMapping("/atualizarFornecedor/{fornecedor}")
    public ResponseEntity<Object> AlterarFornecedor(@PathVariable @Valid String fornecedor,
                                                    @RequestBody @Valid FornecedoresDto fornecedoresDto){
        fornecedoresService.alterarFornecedor(fornecedor, fornecedoresDto);
        return ResponseEntity.ok("Atualização do " + fornecedor + "efetuada com sucesso!");
    }

    @DeleteMapping("/{fornecedor}")
    public ResponseEntity<Object> excluirFornecedor(@PathVariable @Valid String fornecedor){
        fornecedoresService.excluirFornecedor(fornecedor);
        return  ResponseEntity.ok("Fornecedor " + fornecedor + "excluído com sucesso!");
    }
}