package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Integer id;
    @NonNull
    private String produto;
    @NonNull
    private Integer categoria;
    @NonNull
    private Integer fornecedor;
    @NonNull
    private  UnidadeMedida unidadeMedida;
    @NonNull
    private Double valor;
    private Integer quantidade;
    private Integer estoqueMinimo;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.categoria = produto.getCategoria().getIdCategoria();
        this.fornecedor = produto.getFornecedor().getIdFornecedor();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.estoqueMinimo = produto.getEstoqueMinimo();
    }
}
