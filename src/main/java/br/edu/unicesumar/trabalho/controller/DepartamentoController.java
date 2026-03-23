package br.edu.unicesumar.trabalho.controller;

import br.edu.unicesumar.trabalho.entity.Departamento;
import br.edu.unicesumar.trabalho.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento departamento){
        Departamento request =  departamentoService.criarDepartamento(departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos(){
        List<Departamento> departamentos = departamentoService.listarDepartamentos();
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id){
        Departamento request = departamentoService.buscarDepatamentoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamentoPorId(@PathVariable Long id){
        departamentoService.deletarDepartamentoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
