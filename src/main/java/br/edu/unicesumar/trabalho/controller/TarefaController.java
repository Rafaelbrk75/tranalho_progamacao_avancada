package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Tarefa;
import br.edu.unicesumar.trabalho.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(Tarefa tarefa) {
        Tarefa request = tarefaService.criarTarefa(tarefa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefa(@RequestBody Tarefa tarefa) {
        List<Tarefa> request =tarefaService.listarTarefas(tarefa);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Long id) {
        Tarefa request = tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
