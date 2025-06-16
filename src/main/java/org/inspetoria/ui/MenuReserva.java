package org.inspetoria.ui;

import org.inspetoria.model.*;
import org.inspetoria.service.ReservaService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuReserva {
    public static void menu(Scanner scanner) throws SQLException {
        ReservaService reservaService = new ReservaService();
        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Reserva =====");
                System.out.println("1. Inserir");
                System.out.println("2. Listar");
                System.out.println("3. Editar");
                System.out.println("4. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha a opção desejada: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> inserirReserva(scanner, reservaService);
                    case 2 -> listarReservas(reservaService);
                    case 3 -> editarReserva(scanner, reservaService);
                    case 4 -> excluirReserva(scanner, reservaService);
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("valor digitado não é válido.");
            }

        } while (op != 0);
    }

    private static void inserirReserva(Scanner scanner, ReservaService reservaService) {
        try {
            LocalDateTime dataHora;
            System.out.print("Data e hora da reserva (dd/mm/aaaa hh:mm): ");
            String dataHoraStr = scanner.nextLine()
                    .replaceAll("(\\d{2})/(\\d{2})/(\\d{4}) (\\d{2}):(\\d{2})", "$3-$2-$1T$4:$5");
            dataHora = LocalDateTime.parse(dataHoraStr);

            System.out.print("ID do turno: ");
            int turnoId = Integer.parseInt(scanner.nextLine());

            System.out.print("ID da sala de aula: ");
            int salaId = Integer.parseInt(scanner.nextLine());

            System.out.print("ID da turma: ");
            int turmaId = Integer.parseInt(scanner.nextLine());

            System.out.print("ID do professor: ");
            int professorId = Integer.parseInt(scanner.nextLine());

            Reserva reserva = new Reserva();
            reserva.setDataHora(dataHora);
            reserva.setTurno(new Turno(turnoId));
            reserva.setSalaDeAula(new SalaDeAula(salaId));
            reserva.setTurma(new Turma(turmaId));
            reserva.setProfessor(new Professor(professorId));

            if (reservaService.inserir(reserva))
                System.out.println("Reserva inserida com sucesso!");
            else
                System.out.println("Erro ao inserir reserva");
        } catch (Exception e) {
            System.out.println("Erro ao inserir reserva: " + e.getMessage());
        }
    }

    private static void listarReservas(ReservaService reservaService) {
        System.out.println("\n===== Lista de Reservas =====");
        ResultSet rs = reservaService.listar();
        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | DataHora: " + rs.getString("data_hora")
                        + " | Turno ID: " + rs.getInt("id_turno")
                        + " | Sala ID: " + rs.getInt("id_sala_aula")
                        + " | Turma ID: " + rs.getInt("id_turma")
                        + " | Professor ID: " + rs.getInt("id_professor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar reservas.");
            e.printStackTrace();
        }
    }

    private static void editarReserva(Scanner scanner, ReservaService reservaService) {
        try {
            System.out.print("ID da reserva a editar: ");
            int id = Integer.parseInt(scanner.nextLine());

            LocalDateTime dataHora;
            try {
                System.out.print("Nova data e hora (dd/mm/aaaa hh:mm): ");
                String dataHoraStr = scanner.nextLine()
                        .replaceAll("(\\d{2})/(\\d{2})/(\\d{4}) (\\d{2}):(\\d{2})", "$3-$2-$1T$4:$5");
                dataHora = LocalDateTime.parse(dataHoraStr);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use o padrão AAAA-MM-DDThh:mm.");
                return;
            }

            System.out.print("Novo ID do turno: ");
            int turnoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo ID da sala: ");
            int salaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo ID da turma: ");
            int turmaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo ID do professor: ");
            int professorId = Integer.parseInt(scanner.nextLine());

            Reserva reserva = new Reserva(id);
            reserva.setDataHora(dataHora);
            reserva.setTurno(new Turno(turnoId));
            reserva.setSalaDeAula(new SalaDeAula(salaId));
            reserva.setTurma(new Turma(turmaId));
            reserva.setProfessor(new Professor(professorId));

            if (reservaService.editar(reserva)) {
                System.out.println("Reserva editada com sucesso!");
            } else {
                System.out.println("Erro ao editar reserva.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao editar reserva: " + e.getMessage());
        }
    }

    private static void excluirReserva(Scanner scanner, ReservaService reservaService) {
        try {
            System.out.print("ID da reserva a excluir: ");
            int id = Integer.parseInt(scanner.nextLine());

            Reserva reserva = new Reserva(id);
            if (reservaService.excluir(reserva)) {
                System.out.println("Reserva excluída com sucesso!");
            } else {
                System.out.println("Erro ao excluir reserva.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }
}
