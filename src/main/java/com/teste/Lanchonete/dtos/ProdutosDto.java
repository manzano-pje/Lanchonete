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
    String nomeProduto;
    Integer idFornecedor;
    Integer idCategoria;
    private UnidadeMedida unidadeMedida;
    Double valor;

    public ProdutosDto(Produtos produtos, Fornecedores fornecedores, Categorias categorias, UnidadeMedida unidadeMedida) {
        this.idProduto = produtos.getIdProduto();
        this.nomeProduto = produtos.getNomeProduto();
        this.idFornecedor = fornecedores.getIdFornecedor();
        this.idCategoria = categorias.getIdCategoria();
        this.unidadeMedida = unidadeMedida;
        this.valor = produtos.getValor();
    }
}
