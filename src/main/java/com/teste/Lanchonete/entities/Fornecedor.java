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
@Table(name = "tb_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idFornecedor;
    String nome;
    String cnpj;
    String inscMunicipal;
    String inscEstadual;
    String endereco;
    String numero;
    String complemento;
    String bairro;
    String cidade;
    String uf;
    String cep;
    String email;
    String telefone;


//    /*******************
//     * RELACIONAMENTOS
//     *******************/
//
//    @OneToMany(mappedBy = "fornecedor")
//    private List<Produtos> produtosList;


}
