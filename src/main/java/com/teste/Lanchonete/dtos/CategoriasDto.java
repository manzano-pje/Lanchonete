package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Categorias;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriasDto {

    Integer idCategoria;
    @NotBlank(message = "Nome da categoria não pode ser branco ou nulo!")
    String nomeCategoria;

    public CategoriasDto(Categorias categorias) {
        this.idCategoria = categorias.getIdCategoria();
        this.nomeCategoria = categorias.getNomeCategoria();
    }
}
