package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Tarefa;
import br.edu.unicesumar.trabalho.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(Tarefa tarefa){
        return tarefaRepository.findAll();
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).get();
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }
}
