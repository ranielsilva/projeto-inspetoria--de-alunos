package org.example;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private LocalDateTime dataHora;
    private Turno turno;
    private SalaDeAula salaDeAula;
    private Turma turma;
    private Professor professor;

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
