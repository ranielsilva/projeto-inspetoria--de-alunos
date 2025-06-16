package org.inspetoria.ui;

import org.inspetoria.model.Curso;
import org.inspetoria.service.CursoService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuCurso {
    public static void menu(Scanner scanner) throws SQLException {
        CursoService cursoService = new CursoService();

        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Curso =====");
                System.out.println("1. Inserir");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha a opção desejada: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> {
                        System.out.println("Digite o nome do curso: ");
                        String nome = scanner.nextLine();
                        System.out.println("Digite a quatidade de períodos: ");
                        int num = scanner.nextInt();

                        Curso curso = new Curso(nome, num);

                        if (cursoService.inserir(curso))
                            System.out.println("curso inserido com sucesso!");
                        else
                            System.out.println("curso não foi inserido!");
                    }
                    case 2 -> {
                        System.out.println("\n===== Lista de Cursos =====");
                        System.out.println("_______________________");
                        ResultSet rs = cursoService.listar();

                        try {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id")
                                        + " | Nome: " + rs.getString("nome")
                                        + " | Períodos: " + rs.getInt("numero_periodos"));

                            }
                            System.out.println("_______________________");
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar cursos.");
                        }
                    }
                    case 3 -> {
                        ResultSet rs = cursoService.listar();
                        try {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id")
                                        + " | Nome: " + rs.getString("nome")
                                        + " | Períodos: " + rs.getInt("numero_periodos"));

                            }
                            System.out.println("_______________________");
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar cursos.");
                        }

                        System.out.println("\n===== Editar Curso =====");
                        System.out.print("id do curso a editar: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Novo nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Novo número de períodos: ");
                        int num = Integer.parseInt(scanner.nextLine());

                        Curso curso = new Curso(id, nome, num);

                        if (cursoService.editar(curso)) {
                            System.out.println("Curso editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar curso.");
                        }

                    }
                    case 4 -> {

                        System.out.println("\n--- Excluir Curso ---");
                        System.out.print("ID do curso a excluir: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Curso curso = new Curso(id);

                        if (cursoService.excluir(curso)) {
                            System.out.println("Curso excluído com sucesso!");
                        } else {
                            System.out.println("Erro ao excluir curso.");
                        }
                    }

                    case 0 -> System.out.println("voltando...");
                }
            } catch (NumberFormatException e) {
                System.out.println("valor digitado não é válido.");
                ;
            }

        } while (op != 0);

    }
}
