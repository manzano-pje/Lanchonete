package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.EmpresaDto;
import com.teste.Lanchonete.entities.Empresa;
import com.teste.Lanchonete.exceptions.EmpresaJaExisteException;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.NaoExisteEmpresaException;
import com.teste.Lanchonete.repositories.EmpresaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final ModelMapper mapper;

    public EmpresaDto criarEmpresa(EmpresaDto empresaDto) {
        try {
            long procura = empresaRepository.count();
            if (procura > 0)
                throw new EmpresaJaExisteException();
            Empresa empresa = mapper.map(empresaDto, Empresa.class);
            empresaRepository.save(empresa);
            return mapper.map(empresa, EmpresaDto.class);
        }catch (DataAccessException err) {
            throw new ErroDoServidorException();
        }
    }

    public List<EmpresaDto> listarEmpresa() {
        try {
            List<Empresa> lista = empresaRepository.findAll();
            if (lista.isEmpty())
                throw new NaoExisteEmpresaException();

            return lista.stream().
                   map(EmpresaDto::new).
                   collect(Collectors.toList());
        } catch (DataAccessException err) {
            throw new ErroDoServidorException();
        }
    }

    public void atualizarEmpresa(String cnpj, EmpresaDto empresaDto) {
        Empresa empresa = empresaRepository.findByCnpj(cnpj).
                orElseThrow(NaoExisteEmpresaException::new);
        empresa.atualizar(empresaDto);
        empresaRepository.save(empresa);
    }

    public void apagarEmpresa(String cnpj) {
        Empresa empresa = empresaRepository.findByCnpj(cnpj).
                orElseThrow(NaoExisteEmpresaException::new);
        empresaRepository.delete(empresa);
    }
}
