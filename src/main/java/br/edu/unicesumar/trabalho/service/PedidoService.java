package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Pedido;
import br.edu.unicesumar.trabalho.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
