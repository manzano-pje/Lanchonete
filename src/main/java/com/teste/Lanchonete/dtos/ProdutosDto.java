package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {

    Integer id;
    @NonNull
    String produto;
    private Integer categoria;
    private Integer fornecedor;
    private UnidadeMedida unidadeMedida;
    Double valor;

    public ProdutosDto(Produtos produtos) {
        this.id = produtos.getIdProduto();
        this.produto = produtos.getProduto();
        this.unidadeMedida = produtos.getUnidadeMedida();
        this.valor = produtos.getValor();

        this.categoria = produtos.getCategorias().getIdCategoria();
        this.fornecedor = produtos.getFornecedores().getIdFornecedor();
    }
}
