package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.Enums.UnidadeMedida;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "tb_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProdutoId;
    String nomeProduto;

    Integer idFornecedor;
    Integer idCategoria;

    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

    Double valor;

    /******************
     * RELACIONAMENTOS
     ******************/

    @ManyToOne
    @JoinColumn(name = "idFornecedor", insertable = false, updatable = false)
    private Fornecedores fornecedores;

    @ManyToOne
    @JoinColumn(name = "idCategoria", insertable = false,updatable = false)
    private Categorias categorias;
}
