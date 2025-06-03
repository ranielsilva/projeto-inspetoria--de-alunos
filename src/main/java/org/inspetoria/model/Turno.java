package org.inspetoria.model;

import java.time.LocalTime;

public class Turno {
    private int id;
    private String nome;
    private LocalTime horaInicio;
    private LocalTime horaFim;


    public Turno(int id, String nome, LocalTime horaInicio, LocalTime horaFim) {
        this.id = id;
        this.nome = nome;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
    public Turno(String nome, LocalTime horaInicio, LocalTime horaFim) {
        this.nome = nome;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
    public Turno(int id) {this.id = id;}

    public int getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public void setId(int id) { this.id = id; }

    public LocalTime getHoraInicio() { return horaInicio; }

    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFim() { return horaFim; }

    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }
}
