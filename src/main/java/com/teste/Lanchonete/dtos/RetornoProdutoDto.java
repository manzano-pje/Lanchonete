package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoProdutoDto {

    private String produto;
    private String categoria;
    private String fornecedor;
    private UnidadeMedida unidadeMedida;
    private Double valor;

    public RetornoProdutoDto(Produto produto){
        this.produto = produto.getProduto();
        this.categoria = produto.getCategoria().getNomeCategoria();
        this.fornecedor = produto.getFornecedor().getNome();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valor = produto.getValor();
    }
}
