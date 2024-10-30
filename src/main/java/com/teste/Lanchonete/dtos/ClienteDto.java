package com.teste.Lanchonete.dtos;

import com.teste.Lanchonete.entities.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;

/**
 *  cliente dto
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {

    private Integer idCliente;
    @NonNull
    private String nome;
    @NonNull
    @CPF
    private String cpf;
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
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido!")
    private String telefone;

    public ClienteDto(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.endereco = cliente.getEndereco();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade();
        this.uf = cliente.getUf();
        this.cep = cliente.getCep();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }


}
