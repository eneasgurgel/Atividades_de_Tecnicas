package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.model.Produto;
import br.edu.uni7.tecnicasapp2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id){
        return produtoRepository.findById(id).get();
    }

    public Produto create(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    public Produto update(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    public void remove(Integer id){
        produtoRepository.deleteById(id);
    }


}
