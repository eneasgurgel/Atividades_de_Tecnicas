package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.model.Compra;
import br.edu.uni7.tecnicasapp2.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    @Autowired
    public  CompraService(CompraRepository compraRepository){
        this.compraRepository = compraRepository;
    }

    public List<Compra> list() {
        return compraRepository.findAll();
    }

    public Compra findById(Integer id) {
        return compraRepository.findById(id).get();
    }

    public Compra create(Compra compra) {
        compraRepository.save(compra);
        return compra;
    }

    public Compra update(Compra compra) {
        compraRepository.save(compra);
        return compra;
    }

    public void remove(Integer id) {
        compraRepository.deleteById(id);
    }
}
