package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    private String produto;
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    Double valor;

    /******************
     * RELACIONAMENTOS
     ******************/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFornecedor")
    private Fornecedores fornecedores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria")
    private Categorias categorias;
}
