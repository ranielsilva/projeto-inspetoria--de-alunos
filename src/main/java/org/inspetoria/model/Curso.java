package org.inspetoria.model;

public class Curso {
    private int id;
    private String nome;
    private int numeroPeriodo;

    public Curso(int id, String nome, int numeroPeriodo) {
        this.id = id;
        this.nome = nome;
        this.numeroPeriodo = numeroPeriodo;
    }

    public Curso(){
        this.nome = nome;
        this.numeroPeriodo = numeroPeriodo;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getNumeroPeriodo() { return numeroPeriodo; }

    public void setNumeroPeriodo(int numeroPeriodo) { this.numeroPeriodo = numeroPeriodo; }
}
