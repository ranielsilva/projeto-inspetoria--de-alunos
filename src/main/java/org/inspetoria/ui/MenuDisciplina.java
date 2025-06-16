package org.inspetoria.ui;

import org.inspetoria.model.Disciplina;
import org.inspetoria.service.DisciplinaService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDisciplina {
    public static void menu(Scanner scanner) throws SQLException {
        DisciplinaService disciplinaService = new DisciplinaService();

        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Disciplina =====");
                System.out.println("1. Inserir");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha a opção desejada: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> inserirDisciplina(scanner, disciplinaService);
                    case 2 -> listarDisciplinas(disciplinaService);
                    case 3 -> editarDisciplina(scanner, disciplinaService);
                    case 4 -> excluirDisciplina(scanner, disciplinaService);
                    case 0 -> System.out.println("voltando...");
                }

            } catch (NumberFormatException e) {
                System.out.println("valor digitado não é válido.");
            }

        } while (op != 0);
    }

    private static void inserirDisciplina(Scanner scanner, DisciplinaService disciplinaService) {
        System.out.println("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();

        Disciplina disciplina = new Disciplina(nome);

        if (disciplinaService.inserir(disciplina)) {
            System.out.println("disciplina inserida com sucesso!");
        } else {
            System.out.println("disciplina não foi inserida!");
        }
    }

    private static void listarDisciplinas(DisciplinaService disciplinaService) {
        System.out.println("\n===== Lista de Disciplina =====");
        System.out.println("_______________________");
        ResultSet rs = disciplinaService.listar();

        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome"));
            }
            System.out.println("_______________________");
        } catch (SQLException e) {
            System.out.println("Erro ao listar disciplinas.");
        }
    }

    private static void editarDisciplina(Scanner scanner, DisciplinaService disciplinaService) {
        listarDisciplinas(disciplinaService);

        System.out.println("\n===== Editar Disciplina =====");
        System.out.print("id da diciplina a editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        Disciplina disciplina = new Disciplina(id, nome);

        if (disciplinaService.editar(disciplina)) {
            System.out.println("disciplina editada com sucesso!");
        } else {
            System.out.println("Erro ao editar disciplina.");
        }
    }

    private static void excluirDisciplina(Scanner scanner, DisciplinaService disciplinaService) {
        System.out.println("\n--- Excluir Disciplina ---");
        System.out.print("ID da disciplina a excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        Disciplina disciplina = new Disciplina(id);

        if (disciplinaService.excluir(disciplina)) {
            System.out.println("disciplina excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir disciplina.");
        }
    }
}
