package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.CategoriasDto;
//import com.teste.Lanchonete.services.CategoriasService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/categorias/")
public class CategoriasController {

//    private final CategoriasService categoriaService;

//    @PostMapping
//    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CategoriasDto categoriasDto){

//        CategoriasDto retorno = categoriaService.criarCategoria(categoriasDto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/categoria}").
//                buildAndExpand(retorno.getNomeCategoria()).toUri();
//        return ResponseEntity.created(uri).body("Categoria criada com sucesso!");
//    }
}
