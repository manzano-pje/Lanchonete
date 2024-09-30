package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.CategoriasDto;
//import com.teste.Lanchonete.services.CategoriasService;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import com.teste.Lanchonete.services.CategoriasService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/categorias")
public class CategoriasController {

    private final CategoriasService categoriaService;
    private final CategoriasRepository categoriasRepository;

    @PostMapping
    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CategoriasDto categoriasDto){
        CategoriasDto retorno = categoriaService.criarCategorias(categoriasDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/categoria}").
                buildAndExpand(retorno.getNomeCategoria()).toUri();
        return ResponseEntity.created(uri).body("Categoria criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<CategoriasDto>> listarCategorias(){
        List<CategoriasDto> retorno = categoriaService.listarCategorias();
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping("/listar/{nome}")
    public ResponseEntity<CategoriasDto> listarUmaCategoria(@PathVariable @Valid String nome){
        CategoriasDto retorno = categoriaService.listarUmaCategoria(nome);
        return ResponseEntity.ok().body(retorno);
    }

    @PatchMapping("/alterar/{nome}")
    public ResponseEntity<Object> atualizarCategoria(@PathVariable @Valid String nome,
                                                            @RequestBody @Valid CategoriasDto categoriasDto){
        categoriaService.atualizarCategoria(nome, categoriasDto);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }

}
