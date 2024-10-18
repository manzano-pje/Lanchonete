package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Fornecedor;
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
public class FornecedorDto {
    Integer idFornecedor;
    @NonNull
    String nome;
    @NonNull
    @CNPJ(message = "Formato do CNPJ inválido. Escreva o CNPJ no formato '99.999.999\\99999-99'")
    String cnpj;
    String inscMunicipal;
    String inscEstadual;
    @NonNull
    @Size(min = 3, message = "O campo rua precisa ter no mínimo 3 caracteres!")
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
    @Email(message = "Formato do e-mail inválido")
    String email;
    @NonNull
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    String telefone;

    public FornecedorDto(Fornecedor fornecedor) {
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.nome = fornecedor.getNome();
        this.cnpj = fornecedor.getCnpj();
        this.inscMunicipal = fornecedor.getInscMunicipal();
        this.inscEstadual = fornecedor.getInscEstadual();
        this.endereco = fornecedor.getEndereco();
        this.numero = fornecedor.getNumero();
        this.complemento = fornecedor.getComplemento();
        this.bairro = fornecedor.getBairro();
        this.cidade = fornecedor.getCidade();
        this.uf = fornecedor.getUf();
        this.cep = fornecedor.getCep();
        this.email = fornecedor.getEmail();
        this.telefone = fornecedor.getTelefone();
    }
}
