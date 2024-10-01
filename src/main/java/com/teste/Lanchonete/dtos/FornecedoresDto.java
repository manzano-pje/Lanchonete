package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Fornecedores;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedoresDto {
    Integer idFornecedor;
    @NonNull
    String nome;
    @NonNull
    @CNPJ
    String cnpj;
    String inscMunicipal;
    String inscEstadual;
    @NonNull
    String endereco;
    @NonNull
    String numero;
    String complemento;
    @NonNull
    String bairro;
    @NonNull
    String cidade;
    @NonNull
    @Size(min = 2, max = 2)
    String uf;
    @NonNull
    @Pattern(regexp = "\\d{5}-\\d{3}",message = "O cep deve ser no fornato XXXXX-XXX")
    String cep;
    @NonNull
    @Email
    String email;
    @NonNull
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    String telefone;

    public FornecedoresDto(Fornecedores fornecedores) {
        this.idFornecedor = fornecedores.getIdFornecedor();
        this.nome = fornecedores.getNome();
        this.cnpj = fornecedores.getCnpj();
        this.inscMunicipal = fornecedores.getInscMunicipal();
        this.inscEstadual = fornecedores.getInscEstadual();
        this.endereco = fornecedores.getEndereco();
        this.numero = fornecedores.getNumero();
        this.complemento = fornecedores.getComplemento();
        this.bairro = fornecedores.getBairro();
        this.cidade = fornecedores.getCidade();
        this.uf = fornecedores.getUf();
        this.cep = fornecedores.getCep();
        this.email = fornecedores.getEmail();
        this.telefone = fornecedores.getTelefone();
    }
}
