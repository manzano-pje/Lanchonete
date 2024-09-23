package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.CategoriasDto;
import com.teste.Lanchonete.entities.Categorias;
import com.teste.Lanchonete.repositories.CategoriasRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private final ModelMapper mapper;

    public ResponseEntity<CategoriasDto> criarCategorias(CategoriasDto categoriasDto){
        Optional<Categorias> categoriasOptional = categoriasRepository.findByNome(categoriasDto.getNomeCategoria());

    }

}
