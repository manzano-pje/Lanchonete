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
    private Integer categoria;
    @NonNull
    private Integer fornecedor;
    @NonNull
    private UnidadeMedida unidadeMedida;
    @NonNull
    Double valor;

    public ProdutoDto(Produto produto, Categoria categoria, Fornecedor fornecedor) {
        this.id = produto.getIdProduto();
        this.produto = produto.getProduto();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valor = produto.getValor();
        this.categoria = categoria.getIdCategoria();
        this.fornecedor = fornecedor.getIdFornecedor();
    }
}
