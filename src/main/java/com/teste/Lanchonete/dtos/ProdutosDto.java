package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {

    Integer idProdutoId;
    String nomeProduto;
    Integer fornecedor;
    Integer categoria;
    UnidadeMedida unidadeMedida;
    Double valorProduto;
}
