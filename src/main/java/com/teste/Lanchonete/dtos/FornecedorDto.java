package com.teste.Lanchonete.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDto {
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
}
