package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Categoria;
import br.edu.unicesumar.trabalho.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorId(Long id){
        return categoriaRepository.findById(id).get();
    }

    public void deletarCategoriaPorId(Long id){
        categoriaRepository.deleteById(id);
    }
}
