package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
