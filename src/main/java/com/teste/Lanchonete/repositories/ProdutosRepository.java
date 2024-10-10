package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public  interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

    Optional<Produtos> findByNomeProduto(String nome);

}
