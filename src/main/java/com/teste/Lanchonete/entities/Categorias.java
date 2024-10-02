package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_categoria")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCategoria;
    String nomeCategoria;


    /*********************
     * RELACIONAMENTOS
     *********************/

//    @OneToMany(mappedBy = "categorias")
//    private List<Produtos> produtosList;
//
//    @ManyToOne
//    @JoinColumn(name = "idGrupo",insertable = false,updatable = false)
//    private Grupo grupo;

}
