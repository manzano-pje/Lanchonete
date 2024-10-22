package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import com.teste.Lanchonete.dtos.ProdutoDto;
import jakarta.persistence.*;
import lombok.*;

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
    }

    /******************
     * RELACIONAMENTOS
     ******************/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFornecedor")
    private @NonNull Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}
