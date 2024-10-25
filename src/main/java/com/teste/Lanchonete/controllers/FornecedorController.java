package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.FornecedorDto;
import com.teste.Lanchonete.services.FornecedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"v1/fornecedores"})
public class FornecedorController {

    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Object> criarFornecedores(@RequestBody @Valid FornecedorDto fornecedorDto) {
        FornecedorDto fornecedores = fornecedorService.criarFornecedores(fornecedorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor "+ fornecedorDto.getNome() + " cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> listarTodosFornecedores(){
        List<FornecedorDto> fornecedores = fornecedorService.listarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("{cnpj}")
    public ResponseEntity<FornecedorDto> listarUmFornecedor(@PathVariable @Valid String cnpj){
        FornecedorDto fornecedorDto = fornecedorService.listarUmFornecedor(cnpj);
        return ResponseEntity.ok(fornecedorDto);
    }

    @PatchMapping("/{cnpj}`")
    public ResponseEntity<Object> AlterarFornecedor(@PathVariable String cnpj, @RequestBody @Valid FornecedorDto fornecedorDto){
        fornecedorService.alterarFornecedor(cnpj, fornecedorDto);
        return ResponseEntity.ok("Atualização do " + fornecedorDto.getNome() + "efetuada com sucesso!");
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Object> excluirFornecedor(@PathVariable @Valid String cnpj){
        fornecedorService.excluirFornecedor(cnpj);
        return  ResponseEntity.ok("Fornecedor excluído com sucesso!");
    }
}
