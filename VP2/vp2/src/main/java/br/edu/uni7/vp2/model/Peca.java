package br.edu.uni7.vp2.model;

public class Peca {

    private Integer id;
    private String nome;
    private String fabricante;
    private Integer qtdEstoque;
    private double preco;

    public Peca(){

    }

    public Peca(Integer id, String nome, String fabricante, Integer qtdEstoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
