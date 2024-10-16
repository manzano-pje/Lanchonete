package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.FornecedoresDto;
import com.teste.Lanchonete.services.FornecedoresService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"v1/fornecedores"})
public class FornecedoresController {

    private FornecedoresService fornecedoresService;

    @PostMapping
    public ResponseEntity<Object> criarFornecedores(@RequestBody @Valid FornecedoresDto fornecedoresDto) {
        FornecedoresDto fornecedores = fornecedoresService.criarFornecedores(fornecedoresDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor "+ fornecedoresDto.getNome() + " cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresDto>> listarTodosFornecedores(){
        List<FornecedoresDto> fornecedores = fornecedoresService.listarTodosFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity<FornecedoresDto> listarUmFornecedor(@PathVariable @Valid Integer id){
        FornecedoresDto fornecedorDto = fornecedoresService.listarUmFornecedor(id);
        return ResponseEntity.ok(fornecedorDto);
    }

    @PatchMapping("/{id}`")
    public ResponseEntity<Object> AlterarFornecedor(@PathVariable Integer id, @RequestBody @Valid FornecedoresDto fornecedoresDto){
        fornecedoresService.alterarFornecedor(id, fornecedoresDto);
        return ResponseEntity.ok("Atualização do " + fornecedoresDto.getNome() + "efetuada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirFornecedor(@PathVariable @Valid Integer id){
        fornecedoresService.excluirFornecedor(id);
        return  ResponseEntity.ok("Fornecedor excluído com sucesso!");
    }
}
