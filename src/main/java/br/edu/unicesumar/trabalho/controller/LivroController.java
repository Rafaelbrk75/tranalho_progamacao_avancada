package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Livro;
import br.edu.unicesumar.trabalho.repository.LivroRepository;
import br.edu.unicesumar.trabalho.service.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro requeste = livroService.criarLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{/id}").buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> requeste = livroService.listarLivros();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Livro requeste = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok().body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivroPorId(@PathVariable Long id) {
        Livro requeste = livroService.buscarLivroPorId(id);
        return   ResponseEntity.noContent().build();
    }
}
