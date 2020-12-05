package com.alelo.crud.cardapio.cardapio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cardapioAlelo")
public class Produto {

    private long id;
    private String categoria;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(){

    }

    public Produto(long id, String categoria, String nome, String descricao, double preco){
        this.id=id;
        this.categoria=categoria;
        this.nome=nome;
        this.descricao=descricao;
        this.preco=preco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="categoria", nullable = false)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Column(name="nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="descricao", nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name="preco", nullable = false)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Produto [id="+id+",categoria="+categoria+",nome="+nome+",descricao="+descricao+",preco"+preco+"]";
    }

}
