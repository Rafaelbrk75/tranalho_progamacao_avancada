package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
