package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Fornecedor;
import br.edu.unicesumar.trabalho.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor bucarFornecedorPorId(Long id){
        return fornecedorRepository.findById(id).get();
    }

    public List<Fornecedor> listarFornecedores(){
        return fornecedorRepository.findAll();
    }

    public void deletarFornecedorPorId(Long id){
        fornecedorRepository.deleteById(id);
    }
}
