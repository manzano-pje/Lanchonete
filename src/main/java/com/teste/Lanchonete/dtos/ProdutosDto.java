package com.teste.Lanchonete.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {

    Integer idProdutoId;
    String nome;
    String fornecedor;
    String categoria;
    String grupo;
    String subgrupo;
    String unidadeMedida;
    Double valor;
}
