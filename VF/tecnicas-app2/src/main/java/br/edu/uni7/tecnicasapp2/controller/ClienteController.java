package br.edu.uni7.tecnicasapp2.controller;


import br.edu.uni7.tecnicasapp2.model.Cliente;
import br.edu.uni7.tecnicasapp2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "cliente", method = RequestMethod.GET)
    public List<Cliente> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "cliente/{id}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "cliente", method = RequestMethod.POST)
    public Cliente create(@RequestBody Cliente cliente){
        return service.create(cliente);
    }

    @ResponseBody
    @RequestMapping(value = "cliente/{id}", method = RequestMethod.PUT)
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente){
        cliente.setId(id);
        return service.update(cliente);
    }

    @ResponseBody
    @RequestMapping(value = "cliente/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }

}
