package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Fornecedor;
import br.edu.unicesumar.trabalho.repository.FornecedorRepository;
import br.edu.unicesumar.trabalho.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor request =  fornecedorService.criarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedor(){
        List<Fornecedor> request = fornecedorService.listarFornecedores();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor>  buscarFornecedorPorId(@PathVariable Long id){
        Fornecedor request = fornecedorService.bucarFornecedorPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedorPorId(@PathVariable Long id){
        fornecedorService.deletarFornecedorPorId(id);
        return ResponseEntity.noContent().build();
    }
}
