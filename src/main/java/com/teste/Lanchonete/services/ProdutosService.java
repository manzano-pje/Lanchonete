package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ProdutosDto;
import com.teste.Lanchonete.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final ModelMapper mapper;

    public ResponseEntity<ProdutosDto> criarProdutos(ProdutosDto produtosDto){

        return null;
    }
}
