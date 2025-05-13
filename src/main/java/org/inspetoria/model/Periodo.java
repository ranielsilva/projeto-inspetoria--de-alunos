package org.inspetoria.model;

public class Periodo {
    private int id;
    private String nome;
    private int ano;
    private int semestre;

    public Periodo(int id, String nome, int ano, int semestre) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
    }

    public int getId() {return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getAno() { return ano; }

    public void setAno(int ano) { this.ano = ano; }

    public int getSemestre() { return semestre; }

    public void setSemestre(int semestre) { this.semestre = semestre; }
}
