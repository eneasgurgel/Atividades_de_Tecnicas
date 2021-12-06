package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Compra;
import br.edu.uni7.tecnicasapp2.model.NotaFiscal;
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
    public Compra update(@PathVariable String id, @RequestBody Compra compra){
        compra.setId(id);
        return service.update(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }

    @ResponseBody
    @RequestMapping(value = "compra/cpf/{cpfCliente}", method = RequestMethod.GET)
    public List<Compra> findById(@PathVariable String cpfCliente){
        return service.findAllByCpfCliente(cpfCliente);
    }

    @ResponseBody
    @RequestMapping(value = "compra/consulta", method = RequestMethod.GET)
    public Compra findByNotaFiscal(@RequestBody NotaFiscal notaFiscal){
        return service.findByNotaFiscal(notaFiscal);
    }
}
