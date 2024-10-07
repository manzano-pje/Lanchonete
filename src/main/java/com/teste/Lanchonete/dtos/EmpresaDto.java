package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Integer id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscMunicipal;
    private String inscEstadual;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String email;
    private String celular;

    public EmpresaDto(Empresa empresa) {

        this.id = empresa.getId();
        this.cnpj = empresa.getCnpj();
        this.razaoSocial = empresa.getRazaoSocial();
        this.nomeFantasia = empresa.getNomeFantasia();
        this.inscMunicipal = empresa.getInscMunicipal();
        this.inscEstadual = empresa.getInscEstadual();
        this.endereco = empresa.getEndereco();
        this.numero = empresa.getNumero();
        this.complemento = empresa.getComplemento();
        this.bairro = empresa.getBairro();
        this.cidade = empresa.getCidade();
        this.uf = empresa.getUf();
        this.cep = empresa.getCep();
        this.email = empresa.getEmail();
        this.celular = empresa.getCelular();
    }
}
