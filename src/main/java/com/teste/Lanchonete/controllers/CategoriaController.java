package com.teste.Lanchonete.controllers;

import com.teste.Lanchonete.dtos.CategoriaDto;
//import com.teste.Lanchonete.services.CategoriaService;
import com.teste.Lanchonete.repositories.CategoriaRepository;
import com.teste.Lanchonete.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"/v1/categorias"})
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CategoriaDto categoriaDto){
        CategoriaDto retorno = categoriaService.criarCategorias(categoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarCategorias(){
        List<CategoriaDto> retorno = categoriaService.listarCategorias();
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> listarUmaCategoria(@PathVariable @Valid Integer id){
        CategoriaDto retorno = categoriaService.listarUmaCategoria(id);
        return ResponseEntity.ok().body(retorno);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> atualizarCategoria(@PathVariable Integer id, @RequestBody @Valid CategoriaDto categoriaDto){
        categoriaService.atualizarCategoria(id, categoriaDto);
        return ResponseEntity.ok("Categoria atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable @Valid Integer id){
        categoriaService.excluirCategoria(id);
        return ResponseEntity.ok("Categoria excluida com sucesso");
    }

}
