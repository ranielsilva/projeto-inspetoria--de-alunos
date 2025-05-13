package org.example;

public class Turma {
    private int id;
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;
    private Periodo periodo;
    private Curso curso;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Professor getProfessor() { return professor; }

    public void setProfessor(Professor professor) { this.professor = professor; }

    public Disciplina getDisciplina() { return disciplina; }

    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }

    public Periodo getPeriodo() { return periodo;
    }

    public void setPeriodo(Periodo periodo) { this.periodo = periodo; }

    public Curso getCurso() { return curso; }

    public void setCurso(Curso curso) { this.curso = curso; }
}
