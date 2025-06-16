package org.inspetoria.ui;

import org.inspetoria.model.SalaDeAula;
import org.inspetoria.service.SalaDeAulaService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuSalaDeAula {
    public static void menu(Scanner scanner) throws SQLException {
        SalaDeAulaService salaService = new SalaDeAulaService();

        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Sala de Aula =====");
                System.out.println("1. Inserir");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha a opção desejada: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> inserirSala(scanner, salaService);
                    case 2 -> listarSalas(salaService);
                    case 3 -> editarSala(scanner, salaService);
                    case 4 -> excluirSala(scanner, salaService);
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("valor digitado não é válido.");
            }
        } while (op != 0);
    }

    private static void inserirSala(Scanner scanner, SalaDeAulaService salaService) {
        System.out.print("Nome da sala: ");
        String nome = scanner.nextLine();

        System.out.print("Capacidade: ");
        int capacidade = Integer.parseInt(scanner.nextLine());

        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        SalaDeAula sala = new SalaDeAula(nome, capacidade, localizacao);

        if (salaService.inserir(sala)) {
            System.out.println("Sala de aula inserida com sucesso!");
        } else {
            System.out.println("Erro ao inserir sala de aula.");
        }
    }

    private static void listarSalas(SalaDeAulaService salaService) {
        System.out.println("\n===== Lista de Salas de Aula =====");
        ResultSet rs = salaService.listar();
        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Capacidade: " + rs.getInt("capacidade")
                        + " | Localização: " + rs.getString("localizacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar salas de aula.");
        }
    }

    private static void editarSala(Scanner scanner, SalaDeAulaService salaService) {
        listarSalas(salaService);

        System.out.print("\nID da sala a editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome da sala: ");
        String nome = scanner.nextLine();

        System.out.print("Nova capacidade: ");
        int capacidade = Integer.parseInt(scanner.nextLine());

        System.out.print("Nova localização: ");
        String localizacao = scanner.nextLine();

        SalaDeAula sala = new SalaDeAula(id, nome, capacidade, localizacao);

        if (salaService.editar(sala)) {
            System.out.println("Sala de aula editada com sucesso!");
        } else {
            System.out.println("Erro ao editar sala de aula.");
        }
    }

    private static void excluirSala(Scanner scanner, SalaDeAulaService salaService) {
        System.out.print("\nID da sala a excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        SalaDeAula sala = new SalaDeAula(id);

        if (salaService.excluir(sala)) {
            System.out.println("Sala de aula excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir sala de aula.");
        }
    }
}
