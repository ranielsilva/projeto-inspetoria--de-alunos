package org.inspetoria.ui;

import org.inspetoria.model.Turno;
import org.inspetoria.service.TurnoService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuTurno {
    public static void menu(Scanner scanner) throws SQLException {
        TurnoService turnoService = new TurnoService();
        int op;

        do {
            System.out.println("\n===== Menu Turno =====");
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
                    System.out.print("Nome do turno: ");
                    String nome = scanner.nextLine();

                    LocalTime inicio = null, fim = null;
                    try {
                        System.out.print("Hora de início (HH:mm): ");
                        inicio = LocalTime.parse(scanner.nextLine());

                        System.out.print("Hora de fim (HH:mm): ");
                        fim = LocalTime.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato inválido. Use HH:mm (ex: 08:00).");
                        break;
                    }

                    Turno turno = new Turno(nome,inicio,fim);

                    if (turnoService.inserir(turno)) {
                        System.out.println("Turno inserido com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir turno.");
                    }
                }

                case 2 -> {
                    System.out.println("\n===== Lista de Turnos =====");
                    ResultSet rs = turnoService.listar();
                    try {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id")
                                    + " | Nome: " + rs.getString("nome")
                                    + " | Início: " + rs.getString("hora_inicio")
                                    + " | Fim: " + rs.getString("hora_fim"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar turnos.");
                    }
                }

                case 3 -> {
                    ResultSet rs = turnoService.listar();
                    try {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id")
                                    + " | Nome: " + rs.getString("nome")
                                    + " | Início: " + rs.getString("hora_inicio")
                                    + " | Fim: " + rs.getString("hora_fim"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar turnos.");
                    }

                    System.out.print("\nID do turno a editar: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    LocalTime inicio = null, fim = null;
                    try {
                        System.out.print("Nova hora de início (hh:mm): ");
                        inicio = LocalTime.parse(scanner.nextLine());

                        System.out.print("Nova hora de fim (hh:mm): ");
                        fim = LocalTime.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de hora inválido.");
                        break;
                    }

                    Turno turno = new Turno(id,nome,inicio,fim);

                    if (turnoService.editar(turno)) {
                        System.out.println("Turno editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar turno.");
                    }
                }

                case 4 -> {
                    System.out.print("ID do turno a excluir: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Turno turno = new Turno(id);

                    if (turnoService.excluir(turno)) {
                        System.out.println("Turno excluído com sucesso!");
                    } else {
                        System.out.println("Erro ao excluir turno.");
                    }
                }

                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);
    }
}
