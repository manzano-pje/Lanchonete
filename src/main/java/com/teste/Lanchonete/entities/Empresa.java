package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.dtos.EmpresaDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void atualizar(EmpresaDto empresaDto){

        if(empresaDto.getRazaoSocial() !=null){
            this.razaoSocial = empresaDto.getRazaoSocial();
        }
        if (empresaDto.getNomeFantasia() != null) {
            this.nomeFantasia = empresaDto.getNomeFantasia();
        }
        if (empresaDto.getInscMunicipal() != null) {
            this.inscMunicipal = empresaDto.getInscMunicipal();
        }
        if (empresaDto.getInscEstadual() != null) {
            this.inscEstadual = empresaDto.getInscEstadual();
        }
        if (empresaDto.getEndereco() != null) {
            this.endereco = empresaDto.getEndereco();
        }
        if (empresaDto.getNumero() != null) {
            this.numero = empresaDto.getNumero();
        }
        if (empresaDto.getComplemento() != null) {
            this.complemento = empresaDto.getComplemento();
        }
        if (empresaDto.getBairro() != null) {
            this.bairro = empresaDto.getBairro();
        }
        if (empresaDto.getCidade() != null) {
            this.cidade = empresaDto.getCidade();
        }
        if (empresaDto.getUf() != null) {
            this.uf = empresaDto.getUf();
        }
        if (empresaDto.getCep() != null) {
            this.cep = empresaDto.getCep();
        }
        if (empresaDto.getEmail() != null) {
            this.email = empresaDto.getEmail();
        }
        if (empresaDto.getCelular() != null) {
            this.celular = empresaDto.getCelular();
        }
    }
}
