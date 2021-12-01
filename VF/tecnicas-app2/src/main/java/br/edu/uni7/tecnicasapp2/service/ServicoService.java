package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.model.Servico;
import br.edu.uni7.tecnicasapp2.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    @Autowired
    public ServicoService(ServicoRepository repository){
        this.repository = repository;
    }

    public List<Servico> list() {
        return repository.findAll();
    }

    public Servico findById(Integer id) {
        return repository.findById(id).get();
    }

    public Servico create(Servico servico) {
        return repository.save(servico);
    }

    public void update(Integer id, Servico servico) {
        repository.save(servico);
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
