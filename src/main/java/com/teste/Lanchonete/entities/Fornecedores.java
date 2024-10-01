package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_fornecedor")
public class Fornecedores {

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


    /*******************
     * RELACIONAMENTOS
     *******************/

    @OneToMany(mappedBy = "fornecedores")
    private List<Produtos> produtosList;
}
