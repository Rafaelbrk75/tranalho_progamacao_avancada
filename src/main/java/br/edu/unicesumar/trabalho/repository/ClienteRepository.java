package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
