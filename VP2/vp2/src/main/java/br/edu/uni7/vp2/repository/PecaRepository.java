package br.edu.uni7.vp2.repository;

import br.edu.uni7.vp2.model.Peca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PecaRepository {

    private final Map<Integer, Peca> pecas;
    private static int contador = 1;

    public PecaRepository(){
        this.pecas = new HashMap<>();
    }

    public Peca findById(Integer id) {
        return pecas.get(id);
    }

    public List<Peca> list(){
        return new ArrayList<>(pecas.values());
    }

    public void insert(Peca peca){
        int id = contador++;
        peca.setId(id);
        pecas.put(id, peca);
    }

    public void update(Integer id, Peca peca){
        peca.setId(id);
        pecas.put(id, peca);
    }

    public void remove(Integer id){
        pecas.remove(id);
    }
}
