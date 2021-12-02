package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Produto;
import br.edu.uni7.tecnicasapp2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public List<Produto> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.GET)
    public Produto findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.POST)
    public Produto create(@RequestBody Produto produto){
        return service.create(produto);
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.PUT)
    public Produto update(@PathVariable Integer id, @RequestBody Produto produto){
        produto.setId(id);
        return service.update(id, produto);
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }

    @ResponseBody
    @RequestMapping(value = "produto/codigoDeBarra/{codigoDeBarra}", method = RequestMethod.GET)
    public List<Produto> findAllByCodigoDeBarra(@PathVariable String codigoDeBarra){
        return service.findAllByCodigoDeBarra(codigoDeBarra);
    }

    @ResponseBody
    @RequestMapping(value = "produto/categoria/{categoria}", method = RequestMethod.GET)
    public List<Produto> findAllByCategoria(@PathVariable String categoria){
        return service.findAllByCategoria(categoria);
    }

    @ResponseBody
    @RequestMapping(value = "produto/faltando", method = RequestMethod.GET)
    public List<Produto> findAllByQuantidadeEquals0(){
        return service.findAllByQuantidadeEquals0();
    }
}
