package br.edu.uni7.vp2.repository;

import br.edu.uni7.vp2.model.Peca;
import br.edu.uni7.vp2.model.Servico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServicoRepository {

    private final Map<Integer, Servico> servicos;
    private static int contador = 1;

    public ServicoRepository(){
        this.servicos = new HashMap<>();
    }

    public Servico findById(Integer id) {
        return servicos.get(id);
    }

    public List<Servico> list(){
        return new ArrayList<>(servicos.values());
    }

    public void insert(Servico servico){
        int id = contador++;
        servico.setId(id);
        servicos.put(id, servico);
    }

    public void update(Integer id, Servico servico){
        servicos.put(id, servico);
    }

    public void remove(Integer id){
        servicos.remove(id);
    }
}
