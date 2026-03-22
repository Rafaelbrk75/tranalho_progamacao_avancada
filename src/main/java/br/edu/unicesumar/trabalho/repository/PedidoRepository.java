package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
