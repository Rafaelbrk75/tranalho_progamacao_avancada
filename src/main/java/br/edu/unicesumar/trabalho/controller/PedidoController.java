package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Pedido;
import br.edu.unicesumar.trabalho.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido requeste = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(requeste);
    }

    @PostMapping
    public ResponseEntity<Pedido> inserirPedido(@RequestBody Pedido pedido) {
        Pedido request = pedidoService.criarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodosPedidos() {
        List<Pedido> request = pedidoService.listarPedidos();

        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
