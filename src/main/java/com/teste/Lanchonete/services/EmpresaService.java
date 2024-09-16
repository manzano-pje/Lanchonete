package com.teste.Lanchonete.services;

import com.teste.Lanchonete.dtos.EmpresaDto;
import com.teste.Lanchonete.entities.Empresa;
import com.teste.Lanchonete.exceptions.EmpresaJaExisteException;
import com.teste.Lanchonete.exceptions.ErroDoServidorException;
import com.teste.Lanchonete.exceptions.NaoExisteEmpresaExciption;
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

    public EmpresaDto criar(EmpresaDto empresaDto) {
        try {
            long procura = this.empresaRepository.count();
            if (procura > 0L) {
                throw new EmpresaJaExisteException();
            } else {
                Empresa empresa = (Empresa)this.mapper.map(empresaDto, Empresa.class);
                this.empresaRepository.save(empresa);
                EmpresaDto retorno = (EmpresaDto)this.mapper.map(empresa, EmpresaDto.class);
                return retorno;
            }
        } catch (DataAccessException var6) {
            throw new ErroDoServidorException();
        }
    }

    public List<EmpresaDto> listar() {
        try {
            List<Empresa> lista = this.empresaRepository.findAll();
            if (lista.isEmpty()) {
                throw new NaoExisteEmpresaExciption();
            } else {
                return (List)lista.stream().map(EmpresaDto::new).collect(Collectors.toList());
            }
        } catch (DataAccessException var2) {
            throw new ErroDoServidorException();
        }
    }

    public void atualizar(String pesquisa, EmpresaDto empresaDto) {
        try {
            Optional<Empresa> empresaOptional = this.empresaRepository.findByCnpj(pesquisa);
            if (empresaOptional.isEmpty()) {
                throw new NaoExisteEmpresaExciption();
            } else {
                Empresa empresa = (Empresa)this.mapper.map(empresaDto, Empresa.class);
                empresa.setCnpj(((Empresa)empresaOptional.get()).getCnpj());
                empresa.setId(((Empresa)empresaOptional.get()).getId());
                this.empresaRepository.save(empresa);
            }
        } catch (DataAccessException var5) {
            throw new ErroDoServidorException();
        }
    }

    public void apagar(String cnpj) {
        try {
            Optional<Empresa> empresaOptional = this.empresaRepository.findByCnpj(cnpj);
            if (empresaOptional.isEmpty()) {
                throw new NaoExisteEmpresaExciption();
            } else {
                this.empresaRepository.delete((Empresa)empresaOptional.get());
            }
        } catch (DataAccessException var3) {
            throw new ErroDoServidorException();
        }
    }
}
