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
        int op;

        do {
            System.out.println("\n===== Menu Reserva =====");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha a opção desejada: ");
            op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (op) {
                case 1 -> {
                    LocalDateTime dataHora = null;

                        System.out.print("Data e hora da reserva (AAAA-MM-DDThh:mm): ");
                        dataHora = LocalDateTime.parse(scanner.nextLine());


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

                        Turno turno = new Turno(turnoId);
                        reserva.setTurno(turno);

                        SalaDeAula sala = new SalaDeAula(salaId);
                        reserva.setSalaDeAula(sala);

                        Turma turma = new Turma(turmaId);
                        reserva.setTurma(turma);

                        Professor professor = new Professor(professorId);
                        reserva.setProfessor(professor);


                        if (reservaService.inserir(reserva))
                            System.out.println("Reserva inserida com sucesso!");
                        else
                            System.out.println("Erro ao inserir reserva");



                }

                case 2 -> {
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

                case 3 -> {
                    System.out.print("ID da reserva a editar: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    LocalDateTime dataHora = null;
                    try {
                        System.out.print("Nova data e hora (AAAA-MM-DDThh:mm): ");
                        dataHora = LocalDateTime.parse(scanner.nextLine());
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato inválido. Use o padrão AAAA-MM-DDThh:mm.");
                        break;
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

                    Turno turno = new Turno(turnoId);
                    reserva.setTurno(turno);

                    SalaDeAula sala = new SalaDeAula(salaId);
                    reserva.setSalaDeAula(sala);

                    Turma turma = new Turma();
                    reserva.setTurma(turma);

                    Professor professor = new Professor(professorId);
                    reserva.setProfessor(professor);

                    if (reservaService.editar(reserva)) {
                        System.out.println("Reserva editada com sucesso!");
                    } else {
                        System.out.println("Erro ao editar reserva.");
                    }
                }

                case 4 -> {
                    System.out.print("ID da reserva a excluir: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Reserva reserva = new Reserva(id);
                    if (reservaService.excluir(reserva)) {
                        System.out.println("Reserva excluída com sucesso!");
                    } else {
                        System.out.println("Erro ao excluir reserva.");
                    }
                }

                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (op != 0);
    }
}
