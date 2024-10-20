package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.dtos.FornecedorDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void atualizar(FornecedorDto fornecedorDto){

        if(fornecedorDto.getIdFornecedor() !=null){
            this.idFornecedor = fornecedorDto.getIdFornecedor();
        }

        if(fornecedorDto.getNome() !=null){
            this.nome = fornecedorDto.getNome();
        }

        if(fornecedorDto.getCnpj() !=null){
            this.cnpj = fornecedorDto.getCnpj();
        }

        if(fornecedorDto.getEndereco() !=null){
            this.endereco = fornecedorDto.getEndereco();
        }

        if(fornecedorDto.getNumero() !=null){
            this.numero = fornecedorDto.getNumero();
        }

        if(fornecedorDto.getBairro() !=null){
            this.bairro = fornecedorDto.getBairro();
        }

        if(fornecedorDto.getCidade() !=null){
            this.cidade = fornecedorDto.getCidade();
        }

        if(fornecedorDto.getUf() !=null){
            this.uf = fornecedorDto.getUf();
        }

        if(fornecedorDto.getCep() !=null){
            this.cep = fornecedorDto.getCep();
        }

        if(fornecedorDto.getEmail() !=null){
            this.email = fornecedorDto.getEmail();
        }

        if(fornecedorDto.getTelefone() !=null){
            this.telefone = fornecedorDto.getTelefone();
        }
    }

    /*******************
     * RELACIONAMENTOS
     *******************/

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtoList;
}
