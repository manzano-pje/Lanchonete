package com.teste.Lanchonete.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.entities.Produto;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoProdutoDto {

    private String produto;
    private String categoria;
    private String fornecedor;
    private UnidadeMedida unidadeMedida;
    private Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    private Integer quantidade;
    private Integer estoqueMinimo;

    public RetornoProdutoDto(Produto produto){
        this.produto = produto.getProduto();
        this.categoria = produto.getCategoria().getNomeCategoria();
        this.fornecedor = produto.getFornecedor().getNome();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valor = produto.getValor();
        this.dataCadastro = produto.getDataCadastro();
        this.quantidade = produto.getQuantidade();
        this.estoqueMinimo = produto.getEstoqueMinimo();
    }
}
