package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.dtos.CategoriaDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idCategoria;
    String nomeCategoria;

    public void atualizar(CategoriaDto categoriaDto) {
        if (categoriaDto.getNomeCategoria() != null) {
            this.nomeCategoria = categoriaDto.getNomeCategoria();
        }
    }

    /*********************
     * RELACIONAMENTOS
     *********************/

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtoList;

}
