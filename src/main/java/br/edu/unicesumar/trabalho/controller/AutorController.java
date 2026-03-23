package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Autor;
import br.edu.unicesumar.trabalho.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/{id}")
    public ResponseEntity<Autor> listarAutorPorId(@PathVariable Long id){
        Autor request = autorService.buscarAutorPorId(id);
        return ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        List<Autor> request = autorService.listarAutores();
        return ResponseEntity.ok(request);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAutorPorId(@PathVariable Long id){
        autorService.deletarAutorPorId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor){
        Autor request = autorService.criarAutor(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }
}
