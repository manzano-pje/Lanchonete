package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Integer> {

    Optional<Fornecedores> findByCnpj(String cnpj);
    Optional<Fornecedores> findByNome(String nome);
    Boolean findByFornecedor(Integer fornecedor);
}
