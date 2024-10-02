package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_subGrupo")
public class SubGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idSubGrupo;
    String nomeSubGrupo;

    /*********************
     * RELACIONAMENTOS
//     *********************/
//
//    @ManyToOne
//    @JoinColumn(name = "idGrupo",insertable = false,updatable = false)
//    private Grupo grupo;
}
