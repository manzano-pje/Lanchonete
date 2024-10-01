package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Integer> {

    Optional findByCnpj(String cnpj);
    Optional findByNome(String nome);
}
