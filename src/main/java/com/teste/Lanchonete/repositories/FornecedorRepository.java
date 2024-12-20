package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    Optional<Fornecedor> findByCnpj(String cnpj);
    Optional<Fornecedor> findById(Integer id);

}
