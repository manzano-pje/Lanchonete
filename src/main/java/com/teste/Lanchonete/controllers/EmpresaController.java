package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.EmpresaDto;
import com.teste.Lanchonete.services.EmpresaService;
import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping({"v1/empresa"})
public class EmpresaController {

    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Object> criarEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
        EmpresaDto empresa = empresaService.criarEmpresa(empresaDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").
                buildAndExpand(empresa.getCnpj()).toUri();
        return ResponseEntity.created(uri).body("Empresa criada!");
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDto>> listarEmpresa() {
        List<EmpresaDto> lista = empresaService.listarEmpresa();
        return ResponseEntity.ok().body(lista);
    }

    @PatchMapping({"/atualizar/{cnpj}"})
    public ResponseEntity<Object> atualizarEmpresa(@PathVariable String cnpj, @RequestBody @Valid EmpresaDto empresaDto) {
        empresaService.atualizarEmpresa(cnpj, empresaDto);
        return ResponseEntity.ok("Dados da empresa atualizados!");
    }

    @DeleteMapping({"apagar/{cnpj}"})
    public ResponseEntity<Object> apagarEmpresa(@PathVariable @Valid String cnpj) {
        empresaService.apagarEmpresa(cnpj);
        return ResponseEntity.ok("Empresa apagada com sucesso!");
    }
}
