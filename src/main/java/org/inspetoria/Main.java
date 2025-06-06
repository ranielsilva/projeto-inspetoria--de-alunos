package org.inspetoria;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.*;
import org.inspetoria.service.*;
import org.inspetoria.ui.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);
        int op = -1;

        do {
            try {


                System.out.println("===== MENU PRINCIPAL =====");
                System.out.println("1. Curso");
                System.out.println("2. Disciplina");
                System.out.println("3. Periodo");
                System.out.println("4. Professor");
                System.out.println("5. Reserva");
                System.out.println("6. Sala De Aula");
                System.out.println("7. Turma");
                System.out.println("8. Turno    ");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> MenuCurso.menu(scanner);
                    case 2 -> MenuDisciplina.menu(scanner);
                    case 3 -> MenuPeriodo.menu(scanner);
                    case 4 -> MenuProfessor.menu(scanner);
                    case 5 -> MenuReserva.menu(scanner);
                    case 6 -> MenuSalaDeAula.menu(scanner);
                    case 7 -> MenuTurma.menu(scanner);
                    case 8 -> MenuTurno.menu(scanner);

                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida!");

                }
            }catch (InputMismatchException e){
                System.out.println("Selecione uma opção válida");
                scanner.nextLine();
            }
        } while (op != 0);

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
        Curso curso = new Curso("MEDICINA",6);

        if (cursoService.inserir(curso))
            System.out.println("curso inserido com sucesso!");
        else
            System.out.println("curso não foi inserido!");

*/
    }
}
