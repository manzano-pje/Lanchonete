package com.teste.Lanchonete.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String cnpj;

    @NonNull
    private String razaoSocial;

    @NonNull
    private String nomeFantasia;

    private Integer inscMunicipal;

    private Integer inscEstadual;

    @NonNull
    private String endereco;

    @NonNull
    private String numero;

    private String complemento;

    @NonNull
    private String bairro;

    @NonNull
    private String cidade;

    @NonNull
    private String uf;

    @NonNull
    private Integer cep;

    @NonNull
    private String email;

    @NonNull
    private Integer celular;

}
