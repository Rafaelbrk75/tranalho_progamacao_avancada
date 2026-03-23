package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Projeto;
import br.edu.unicesumar.trabalho.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id).get();
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public void deletarProjetoPorId(Long id) {
        projetoRepository.deleteById(id);
    }
}
