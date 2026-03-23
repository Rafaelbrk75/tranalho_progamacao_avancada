package br.edu.unicesumar.trabalho.service;

import br.edu.unicesumar.trabalho.entity.Cliente;
import br.edu.unicesumar.trabalho.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).get();
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
