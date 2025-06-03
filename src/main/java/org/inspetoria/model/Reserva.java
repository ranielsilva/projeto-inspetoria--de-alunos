package org.inspetoria.model;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private LocalDateTime dataHora;
    private Turno turno;
    private SalaDeAula salaDeAula;
    private Turma turma;
    private Professor professor;


    public Reserva(int id, LocalDateTime dataHora, Turno turno, SalaDeAula salaDeAula, Turma turma, Professor professor) {
        this.id = id;
        this.dataHora = dataHora;
        this.turno = turno;
        this.salaDeAula = salaDeAula;
        this.turma = turma;
        this.professor = professor;
    }
    public Reserva(LocalDateTime dataHora, Turno turno, SalaDeAula salaDeAula, Turma turma, Professor professor) {
        this.dataHora = dataHora;
        this.turno = turno;
        this.salaDeAula = salaDeAula;
        this.turma = turma;
        this.professor = professor;
    }
    public Reserva(int id) {this.id = id;}

    public Reserva() {
        this.dataHora = dataHora;
        this.turno = turno;
        this.salaDeAula = salaDeAula;
        this.turma = turma;
        this.professor = professor;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }

    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Turno getTurno() { return turno; }

    public void setTurno(Turno turno) { this.turno = turno; }

    public SalaDeAula getSalaDeAula() { return salaDeAula; }

    public void setSalaDeAula(SalaDeAula salaDeAula) { this.salaDeAula = salaDeAula; }

    public Turma getTurma() { return turma; }

    public void setTurma(Turma turma) { this.turma = turma; }

    public Professor getProfessor() { return professor; }

    public void setProfessor(Professor professor) { this.professor = professor; }
}
