package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Categorias;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {

    Optional<Categorias> findBynomeCategoria(@NonNull String nomeCategoria);
    Categorias findByIdCategoria(Integer categoria);
}
