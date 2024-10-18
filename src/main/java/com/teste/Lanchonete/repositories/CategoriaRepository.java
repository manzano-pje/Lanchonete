package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Categoria;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findBynomeCategoria(@NonNull String nomeCategoria);
    Categoria findByIdCategoria(Integer categoria);
}
