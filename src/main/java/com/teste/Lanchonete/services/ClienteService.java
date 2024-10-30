package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.ClienteDto;
import com.teste.Lanchonete.entities.Cliente;
import com.teste.Lanchonete.exceptions.ClienteJaCadastradoException;
import com.teste.Lanchonete.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper mapper;

    public ClienteDto criarCliente(ClienteDto clienteDto){

        Optional<Cliente> clienteOptional = clienteRepository.findByNome(clienteDto.getNome());
        if(clienteOptional.isPresent()){
            throw new ClienteJaCadastradoException();
        }
        Cliente cliente = mapper.map(clienteDto, Cliente.class);
        clienteRepository.save(cliente);
        return mapper.map(cliente, ClienteDto.class);
    }
}
