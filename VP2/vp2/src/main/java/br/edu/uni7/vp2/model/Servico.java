package br.edu.uni7.vp2.model;

import java.util.*;
import br.edu.uni7.vp2.controller.PecaController;
import br.edu.uni7.vp2.repository.PecaRepository;

public class Servico {

    private Integer id;
    private double maoDeObra;
    private List<Peca> pecas;
    private double total;
    private List<Integer> quantidades;

    public Servico() {

    }

    public Servico(Integer id, double maoDeObra, List<Peca> pecas) {
        this.id = id;
        this.maoDeObra = maoDeObra;
        this.pecas = pecas;
        this.total = 0;
    }

    public void calculaTotal(){
        for(int i = 0; i < pecas.size(); i++){
            if (pecas.get(i) != null){
                total = pecas.get(i).getPreco() * quantidades.get(i);
            }
        }
        total += maoDeObra;
    }
    /*
    public void adicionaPeca(Integer id, Integer quantidade){
        PecaRepository repository = PecaController.getRepository();
        if ((repository.findById(id) != null) && (repository.findById(id).getQtdEstoque() >= quantidade)){
            pecas.add(repository.findById(id));
            quantidades.add(quantidade);
        }
    }*/
    public double getTotal() {
        calculaTotal();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
}
