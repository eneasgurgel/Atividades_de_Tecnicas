package br.edu.uni7.vp2.controller;

import br.edu.uni7.vp2.model.Peca;
import br.edu.uni7.vp2.model.Servico;
import br.edu.uni7.vp2.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ServicoController {
    public ServicoRepository getRepository() {
        return repository;
    }

    private final ServicoRepository repository;

    @Autowired
    public ServicoController(ServicoRepository repository){
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "servicos", method = RequestMethod.GET)
    public List<Servico> list(){
        return repository.list();
    }

    @ResponseBody
    @RequestMapping(value = "servicos/{id}", method = RequestMethod.GET)
    public Servico findById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "servicos", method = RequestMethod.POST)
    public Servico create(@RequestBody Servico servico){
        repository.insert(servico);
        return servico;
    }

    @ResponseBody
    @RequestMapping(value = "servicos/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Servico servico){
        repository.update(id, servico);
    }

    @ResponseBody
    @RequestMapping(value = "servicos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        repository.remove(id);
    }
}
