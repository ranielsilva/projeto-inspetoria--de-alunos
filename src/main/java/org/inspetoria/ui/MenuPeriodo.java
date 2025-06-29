package org.inspetoria.ui;

import org.inspetoria.model.Periodo;
import org.inspetoria.service.PeriodoService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuPeriodo {
    public static void menu(Scanner scanner) throws SQLException {
        PeriodoService periodoService = new PeriodoService();

        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Período =====");
                System.out.println("1. Inserir");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha a opção desejada: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> inserirPeriodo(scanner, periodoService);
                    case 2 -> listarPeriodos(periodoService);
                    case 3 -> editarPeriodo(scanner, periodoService);
                    case 4 -> excluirPeriodo(scanner, periodoService);
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida, tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("valor digitado não é válido.");
            }

        } while (op != 0);
    }

    private static void inserirPeriodo(Scanner scanner, PeriodoService periodoService) {
        System.out.print("Digite o nome do período: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o semestre: ");
        int semestre = Integer.parseInt(scanner.nextLine());

        Periodo periodo = new Periodo(nome, ano, semestre);

        if (periodoService.inserir(periodo)) {
            System.out.println("Período inserido com sucesso!");
        } else {
            System.out.println("Erro ao inserir período.");
        }
    }

    private static void listarPeriodos(PeriodoService periodoService) {
        System.out.println("\n===== Lista de Períodos =====");
        System.out.println("_______________________");
        ResultSet rs = periodoService.listar();

        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Ano: " + rs.getInt("ano")
                        + " | Semestre: " + rs.getInt("semestre"));
            }
            System.out.println("_______________________");
        } catch (SQLException e) {
            System.out.println("Erro ao listar períodos.");
        }
    }

    private static void editarPeriodo(Scanner scanner, PeriodoService periodoService) {
        listarPeriodos(periodoService);

        System.out.print("\nID do período a editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo semestre: ");
        int semestre = Integer.parseInt(scanner.nextLine());

        Periodo periodo = new Periodo(id, nome, ano, semestre);

        if (periodoService.editar(periodo)) {
            System.out.println("Período editado com sucesso!");
        } else {
            System.out.println("Erro ao editar período.");
        }
    }

    private static void excluirPeriodo(Scanner scanner, PeriodoService periodoService) {
        System.out.print("\nID do período a excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        Periodo periodo = new Periodo(id);

        if (periodoService.excluir(periodo)) {
            System.out.println("Período excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir período.");
        }
    }
}
