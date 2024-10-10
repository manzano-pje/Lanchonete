package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.EmpresaDto;
import com.teste.Lanchonete.services.EmpresaService;
import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> criar(@RequestBody EmpresaDto empresaDto) {
        EmpresaDto empresa = empresaService.criarEmpresa(empresaDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").
                buildAndExpand(empresa.getCnpj()).toUri();
        return ResponseEntity.created(uri).body("Empresa criada!");
    }

    @GetMapping({"/listarTodos"})
    public ResponseEntity<List<EmpresaDto>> listarTudo() {
        List<EmpresaDto> lista = empresaService.listarEmpresa();
        return ResponseEntity.ok().body(lista);
    }

    @PatchMapping({"/atualizar/{pesquisa}"})
    public ResponseEntity<Object> atualizar(@PathVariable String pesquisa, @RequestBody EmpresaDto empresaDto) {
        empresaService.atualizar(pesquisa, empresaDto);
        return ResponseEntity.ok("Dados da empresa atualizados!");
    }

    @DeleteMapping({"apagar/{cnpj}"})
    public ResponseEntity<Object> apagar(@PathVariable String cnpj) {
        empresaService.apagar(cnpj);
        return ResponseEntity.ok("Empresa apagada com sucesso!");
    }
}
