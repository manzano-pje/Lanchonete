package com.teste.Lanchonete.entities;

import com.teste.Lanchonete.dtos.FornecedoresDto;
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

    public void atualizar(FornecedoresDto fornecedoresDto){

        if(fornecedoresDto.getIdFornecedor() !=null){
            this.idFornecedor = fornecedoresDto.getIdFornecedor();
        }

        if(fornecedoresDto.getNome() !=null){
            this.nome = fornecedoresDto.getNome();
        }

        if(fornecedoresDto.getCnpj() !=null){
            this.cnpj = fornecedoresDto.getCnpj();
        }

        if(fornecedoresDto.getEndereco() !=null){
            this.endereco = fornecedoresDto.getEndereco();
        }

        if(fornecedoresDto.getNumero() !=null){
            this.numero = fornecedoresDto.getNumero();
        }

        if(fornecedoresDto.getBairro() !=null){
            this.bairro = fornecedoresDto.getBairro();
        }

        if(fornecedoresDto.getCidade() !=null){
            this.cidade = fornecedoresDto.getCidade();
        }

        if(fornecedoresDto.getUf() !=null){
            this.uf = fornecedoresDto.getUf();
        }

        if(fornecedoresDto.getCep() !=null){
            this.cep = fornecedoresDto.getCep();
        }

        if(fornecedoresDto.getEmail() !=null){
            this.email = fornecedoresDto.getEmail();
        }

        if(fornecedoresDto.getTelefone() !=null){
            this.telefone = fornecedoresDto.getTelefone();
        }
    }

    /*******************
     * RELACIONAMENTOS
     *******************/

    @OneToMany(mappedBy = "fornecedores")
    private List<Produtos> produtosList;
}
