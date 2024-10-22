package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Categoria;
import com.teste.Lanchonete.entities.Fornecedor;
import com.teste.Lanchonete.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    Integer id;
    @NonNull
    String produto;
    @NonNull
    Integer categoria;
    @NonNull
    Integer fornecedor;
    @NonNull
    private UnidadeMedida unidadeMedida;
    @NonNull
    Double valor;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.produto = produto.getProduto();
        this.categoria = produto.getCategoria().getIdCategoria();
        this.fornecedor = produto.getFornecedor().getIdFornecedor();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valor = produto.getValor();
    }
}
