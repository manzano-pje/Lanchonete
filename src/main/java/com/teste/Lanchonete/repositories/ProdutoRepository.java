package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public  interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByProduto(String nome);
}
