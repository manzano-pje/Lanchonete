package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCategoria;
    String nomeCategoria;


    /*********************
     * RELACIONAMENTOS
     *********************/

    @OneToMany(mappedBy = "categoria")
    private List<Produtos> produtosList;

    @ManyToOne
    @JoinColumn(name = "idGrupo",insertable = false,updatable = false)
    private Grupo grupo;

}
