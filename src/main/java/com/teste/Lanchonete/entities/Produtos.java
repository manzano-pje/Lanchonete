package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    String nome;
    Integer idFornecedor;
    Integer idCategoria;
    Integer idGrupo;
    Integer idSubgrupo;
    Integer idUnidadeMedida;
    Double valor;

    /******************
     * RELACIONAMENTOS
     ******************/

//    @OneToMany(mappedBy = "produtos")
//    private List<UnidadeMedida> unidadeMedidaList;
//
//    @ManyToOne
//    @JoinColumn(name = "idFornecedor", insertable = false, updatable = false)
//    private Fornecedor fornecedor;
//
//    @ManyToOne
//    @JoinColumn(name = "idCategoria", insertable = false,updatable = false)
//    private Categoria categoria;
}
