package com.teste.Lanchonete.repositories;

import com.teste.Lanchonete.entities.Empresa;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Optional findByCnpj(@NonNull String cnpj);
}
