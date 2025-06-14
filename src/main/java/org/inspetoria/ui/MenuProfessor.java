package org.inspetoria.ui;

import org.inspetoria.model.Professor;
import org.inspetoria.service.ProfessorService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuProfessor {
    public static void menu(Scanner scanner) throws SQLException {
        ProfessorService professorService = new ProfessorService();

        int op = -1;

        do {
            try {
                System.out.println("\n===== Menu Professor =====");
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
                        System.out.print("Digite o nome do professor: ");
                        String nome = scanner.nextLine();

                        LocalDate dataNascimento = null;
                        boolean dataValida = false;
                        while (!dataValida) {
                            System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
                            String dataStr = scanner.nextLine();
                            try {
                                dataNascimento = LocalDate.parse(dataStr);
                                dataValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato inválido. Por favor, use o formato AAAA-MM-DD.");
                            }
                        }

                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Digite o endereço: ");
                        String endereco = scanner.nextLine();

                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();

                        System.out.print("Digite o telefone: ");
                        String telefone = scanner.nextLine();

                        Professor professor = new Professor(nome,dataNascimento,cpf,endereco,email,telefone);

                        if (professorService.inserir(professor)) {
                            System.out.println("Professor inserido com sucesso!");
                        } else {
                            System.out.println("Erro ao inserir professor.");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n===== Lista de Professores =====");
                        System.out.println("_______________________");
                        ResultSet rs = professorService.listar();

                        try {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id")
                                        + " | Nome: " + rs.getString("nome")
                                        + " | Data Nascimento: " + rs.getString("data_nascimento")
                                        + " | CPF: " + rs.getString("cpf")
                                        + " | Endereço: " + rs.getString("endereco")
                                        + " | Email: " + rs.getString("email")
                                        + " | Telefone: " + rs.getString("telefone"));
                            }
                            System.out.println("_______________________");
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar professores.");
                        }
                    }

                    case 3 -> {
                        ResultSet rs = professorService.listar();
                        try {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id")
                                        + " | Nome: " + rs.getString("nome")
                                        + " | Data Nascimento: " + rs.getString("data_nascimento")
                                        + " | CPF: " + rs.getString("cpf")
                                        + " | Endereço: " + rs.getString("endereco")
                                        + " | Email: " + rs.getString("email")
                                        + " | Telefone: " + rs.getString("telefone"));
                            }
                            System.out.println("_______________________");
                        } catch (SQLException e) {
                            System.out.println("Erro ao listar professores.");
                        }

                        System.out.print("\nID do professor a editar: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Novo nome: ");
                        String nome = scanner.nextLine();

                        LocalDate dataNascimento = null;
                        boolean dataValida = false;
                        while (!dataValida) {
                            System.out.print("Nova data de nascimento (AAAA-MM-DD): ");
                            String dataStr = scanner.nextLine();
                            try {
                                dataNascimento = LocalDate.parse(dataStr);
                                dataValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Formato inválido. Por favor, use o formato AAAA-MM-DD.");
                            }
                        }

                        System.out.print("Novo CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Novo endereço: ");
                        String endereco = scanner.nextLine();

                        System.out.print("Novo email: ");
                        String email = scanner.nextLine();

                        System.out.print("Novo telefone: ");
                        String telefone = scanner.nextLine();

                        Professor professor = new Professor(id,nome,dataNascimento,cpf,endereco,email,telefone);

                        if (professorService.editar(professor)) {
                            System.out.println("Professor editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar professor.");
                        }
                    }

                    case 4 -> {
                        System.out.print("\nID do professor a excluir: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Professor professor = new Professor(id);

                        if (professorService.excluir(professor)) {
                            System.out.println("Professor excluído com sucesso!");
                        } else {
                            System.out.println("Erro ao excluir professor.");
                        }
                    }

                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("valor digitado não é válido.");
            }



        } while (op != 0);
    }
}
