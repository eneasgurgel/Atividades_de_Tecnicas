package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Compra;
import br.edu.uni7.tecnicasapp2.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompraController {

    private final CompraService service;

    @Autowired
    public CompraController(CompraService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "compra", method = RequestMethod.GET)
    public List<Compra> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.GET)
    public Compra findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "compra", method = RequestMethod.POST)
    public Compra create(@RequestBody Compra compra){
        return service.create(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.PUT)
    public Compra update(@PathVariable Integer id, @RequestBody Compra compra){
        return service.update(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }
}