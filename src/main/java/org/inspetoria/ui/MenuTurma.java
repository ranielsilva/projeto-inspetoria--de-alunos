package org.inspetoria.ui;

import org.inspetoria.model.*;
import org.inspetoria.service.TurmaService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuTurma {
    public static void menu(Scanner scanner) throws SQLException {
        TurmaService turmaService = new TurmaService();
        int op;

        do {
            System.out.println("\n===== Menu Turma =====");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha a opcao desejada: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Codigo da Turma: ");
                    String codigo = scanner.nextLine();

                    System.out.print("ID do Professor: ");
                    int professorId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID da Disciplina: ");
                    int disciplinaId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID do Periodo: ");
                    int periodoId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID do Curso: ");
                    int cursoId = Integer.parseInt(scanner.nextLine());

                    Turma turma = new Turma();
                    turma.setCodigo(codigo);
                    turma.setProfessor(new Professor(professorId));
                    turma.setDisciplina(new Disciplina(disciplinaId));
                    turma.setPeriodo(new Periodo(periodoId));
                    turma.setCurso(new Curso(cursoId));

                    if (turmaService.inserir(turma)) {
                        System.out.println("Turma inserida com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir turma.");
                    }
                }
                case 2 -> {
                    ResultSet rs = turmaService.listar();
                    System.out.println("\n===== Lista de Turmas =====");
                    try {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    " | Codigo: " + rs.getString("codigo") +
                                    " | Professor: " + rs.getInt("id_professor") +
                                    " | Disciplina: " + rs.getInt("id_disciplina") +
                                    " | Periodo: " + rs.getInt("id_periodo") +
                                    " | Curso: " + rs.getInt("id_curso"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar turmas.");
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    System.out.print("ID da turma a editar: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Novo codigo: ");
                    String codigo = scanner.nextLine();

                    System.out.print("ID do Professor: ");
                    int professorId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID da Disciplina: ");
                    int disciplinaId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID do Periodo: ");
                    int periodoId = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID do Curso: ");
                    int cursoId = Integer.parseInt(scanner.nextLine());

                    Turma turma = new Turma();
                    turma.setId(id);
                    turma.setCodigo(codigo);
                    turma.setProfessor(new Professor(professorId));
                    turma.setDisciplina(new Disciplina(disciplinaId));
                    turma.setPeriodo(new Periodo(periodoId));
                    turma.setCurso(new Curso(cursoId));

                    if (turmaService.editar(turma)) {
                        System.out.println("Turma editada com sucesso!");
                    } else {
                        System.out.println("Erro ao editar turma.");
                    }
                }
                case 4 -> {
                    System.out.print("ID da turma a excluir: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Turma turma = new Turma();
                    turma.setId(id);

                    if (turmaService.excluir(turma)) {
                        System.out.println("Turma excluida com sucesso!");
                    } else {
                        System.out.println("Erro ao excluir turma.");
                    }
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opcao invalida.");
            }
        } while (op != 0);
    }
}
