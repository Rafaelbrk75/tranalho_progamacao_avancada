package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Departamento;
import br.edu.unicesumar.trabalho.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento criarDepartamento(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listarDepartamentos(){
        return departamentoRepository.findAll();
    }

    public Departamento buscarDepatamentoPorId(Long id){
        return departamentoRepository.findById(id).get();
    }

    public void deletarDepartamentoPorId(Long id){
        departamentoRepository.deleteById(id);
    }
}
