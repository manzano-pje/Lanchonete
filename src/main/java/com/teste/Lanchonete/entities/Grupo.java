package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idGrupo;
    String nomeGrupo;

    /*********************
     * RELACIONAMENTOS
     *********************/

    @OneToMany
    private List<Categoria> categoriaList;

    @ManyToOne
    @JoinColumn(name = "idSubGrupo",insertable = false,updatable = false)
    private SubGrupo subGrupo;
}
