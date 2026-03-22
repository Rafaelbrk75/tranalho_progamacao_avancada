package br.edu.unicesumar.trabalho.repository;

import br.edu.unicesumar.trabalho.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
