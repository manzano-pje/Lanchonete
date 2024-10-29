package com.teste.Lanchonete.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.dtos.ProdutoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String produto;
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    private Integer quantidade;
    private Integer estoqueMinimo;



    public void atualizar(ProdutoDto produtoDto, Categoria categoria, Fornecedor fornecedor) {
        if (produtoDto.getProduto() != null) {
            this.produto = produtoDto.getProduto();
        }
        if (produtoDto.getUnidadeMedida() != null) {
            this.unidadeMedida = produtoDto.getUnidadeMedida();
        }
        if (produtoDto.getValor() != null){
            this.valor = produtoDto.getValor();
        }

        if (produtoDto.getQuantidade() != null){
            this.quantidade = produtoDto.getQuantidade();
        }

        if (produtoDto.getEstoqueMinimo() != null){
            this.estoqueMinimo = produtoDto.getEstoqueMinimo();
        }
        if (produtoDto.getCategoria() != null) {
            this.categoria = categoria;
        }

        if (produtoDto.getFornecedor() != null) {
            this.fornecedor = fornecedor;
        }
    }


    /******************
     * RELACIONAMENTOS
     ******************/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Fornecedor")
    private @NonNull Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categoria")
    private Categoria categoria;
}
