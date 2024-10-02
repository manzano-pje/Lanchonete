package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "tb_unidMedidas")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUnidadeMedida;
    String nome;

    /******************
     * RELACIONAMENTOS
     ******************/

//    @ManyToOne
//    @JoinColumn(name = "idProdutos", insertable = false, updatable = false)
//    private Produtos produtos;
}
