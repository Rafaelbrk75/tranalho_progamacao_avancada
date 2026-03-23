package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
