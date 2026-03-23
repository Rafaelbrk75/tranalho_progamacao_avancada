package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
