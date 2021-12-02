package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.model.Cliente;
import br.edu.uni7.tecnicasapp2.model.NotaFiscal;
import br.edu.uni7.tecnicasapp2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public  ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente create(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public void remove(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

}
