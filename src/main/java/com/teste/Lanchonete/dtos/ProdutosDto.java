package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.entities.Fornecedores;
import com.teste.Lanchonete.entities.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {

    Integer idProduto;
    String nome;
    Integer fornecedor;
    Integer categoria;
    private UnidadeMedida unidadeMedida;
    Double valor;

    public ProdutosDto(Produtos produtos, Fornecedores fornecedores, Categorias categorias, UnidadeMedida unidadeMedida) {
        this.idProduto = produtos.getIdProduto();
        this.nome = produtos.getNome();
        this.fornecedor = fornecedores.getIdFornecedor();
        this.categoria = categorias.getIdCategoria();
        this.unidadeMedida = unidadeMedida;
        this.valor = produtos.getValor();
    }
}
