package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Autor;
import br.edu.unicesumar.trabalho.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor criarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Autor buscarAutorPorId(Long id) {
        return autorRepository.findById(id).get();
    }

    public void deletarAutorPorId(Long id) {
        autorRepository.deleteById(id);
    }
}

