package org.inspetoria;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.*;
import org.inspetoria.service.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        //TESTE DE INSERÇÃO DE RESERVA
        /*
        Turno turno = new Turno();
        turno.setId(1);

        SalaDeAula salaDeAula = new SalaDeAula();
        salaDeAula.setId(1);

        Turma turma = new Turma();
        turma.setId(1);

        Professor professor = new Professor();
        professor.setId(1);

        ReservaService reservaService = new ReservaService();
        Reserva reserva = new Reserva(LocalDateTime.now(),turno,salaDeAula,turma,professor);

        if (reservaService.inserir(reserva)) {
            System.out.println("reserva inserida com sucesso!");
        }else{
            System.out.println("reserva não foi inserido!");
        }
        */

        //TESTE DE INSERÇÃO DE TURMA
        /*
        Professor professor = new Professor();
        professor.setId(1);

        Disciplina disciplina = new Disciplina();
        disciplina.setId(1);

        Periodo periodo = new Periodo();
        periodo.setId(1);

        Curso curso = new Curso();
        curso.setId(1);

        TurmaService turmaService = new TurmaService();
        Turma turma = new Turma("5", professor, disciplina, periodo, curso);

        if (turmaService.inserir(turma)) {
            System.out.println("turma inserida com sucesso!");
        }else{
            System.out.println("turma não foi inserido!");
        }
        */

        //TESTE DE INSERÇÃO DE TURNO
        /*
        TurnoService turnoService = new TurnoService();
        Turno turno = new Turno("matutino", LocalTime.parse("08:00"),LocalTime.parse("11:00"));

        if (turnoService.inserir(turno)) {
            System.out.println("turno inserido com sucesso!");
        }else{
            System.out.println("turno não foi inserido!");
        }
        */

        //TESTE DE INSERÇÃO DE SALA DE AULA
        /*
        SalaDeAulaService salaDeAulaService = new SalaDeAulaService();
        SalaDeAula salaDeAula = new SalaDeAula("sala 10",30,"3ª andar");

        if (salaDeAulaService.inserir(salaDeAula)) {
            System.out.println("sala de aula inserida com sucesso!");
        }else{
            System.out.println("sala de aula não foi inserido!");
        }
        */

        //TESTE DE INSERÇÃO DE PROFESSOR
        /*
        ProfessorService professorService = new ProfessorService();
        Professor professor = new Professor("maria", LocalDate.of(1965, 10,9),
                "12345678912","maceio AL","maria@gamil.com","82987455623");

        if (professorService.inserir(professor)) {
            System.out.println("professor inserido com sucesso!");
        }else{
            System.out.println("professor não foi inserido!");
        }
        */


        //TESTE DE INSERÇÃO DE PERIODO
        /*
        PeriodoService periodoService = new PeriodoService();
        Periodo periodo = new Periodo("2025.1",2025,1);

        if (periodoService.inserir(periodo)) {
            System.out.println("periodo inserido com sucesso!");
        }else{
            System.out.println("periodo não foi inserido!");
        }
        */

        //TESTE DE INSERÇÃO DE DISCIPLINA
        /*
        DisciplinaService disciplinaService = new DisciplinaService();
        Disciplina disciplina = new Disciplina("Banco de dados");

        if (disciplinaService.inserir(disciplina)) {
            System.out.println("disciplina inserida com sucesso!");
        }else{
            System.out.println("disciplina não foi inserido!");
        }
        */


        //TESTE DE INSERÇÃO DE CURSO
       /*
        CursoService cursoService = new CursoService();
        Curso curso = new Curso("SI",5);

        if (cursoService.inserir(curso)) {
            System.out.println("curso inserido com sucesso!");
        }else{
            System.out.println("curso não foi inserido!");
        }
        */
    }
}
