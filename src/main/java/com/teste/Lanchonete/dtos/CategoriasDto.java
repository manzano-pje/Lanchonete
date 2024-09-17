package com.teste.Lanchonete.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoriasDto {
    Integer idCategoria;

    @NonNull
    String nomeCategoria;

}
