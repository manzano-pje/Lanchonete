package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    Integer idCategoria;
    @NotBlank(message = "Nome da categoria não pode ser branco ou nulo!")
    String nomeCategoria;

    public CategoriaDto(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.nomeCategoria = categoria.getNomeCategoria();
    }
}
