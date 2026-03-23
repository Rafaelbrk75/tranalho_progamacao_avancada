package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
