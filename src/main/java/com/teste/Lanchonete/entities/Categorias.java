package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.dtos.CategoriasDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_categoria")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idCategoria;
    String nomeCategoria;

    public void atualizar(CategoriasDto categoriasDto) {
        if (categoriasDto.getNomeCategoria() != null) {
            this.nomeCategoria = categoriasDto.getNomeCategoria();
        }
    }

    /*********************
     * RELACIONAMENTOS
     *********************/

    @OneToMany(mappedBy = "categorias")
    private List<Produtos> produtosList;

}
