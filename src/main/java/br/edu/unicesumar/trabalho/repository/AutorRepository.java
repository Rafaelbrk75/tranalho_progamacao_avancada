package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
