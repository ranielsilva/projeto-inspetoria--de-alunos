package org.inspetoria.ui;

import org.inspetoria.model.Curso;
import org.inspetoria.model.Disciplina;
import org.inspetoria.service.DisciplinaService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDisciplina {
    public static void menu(Scanner scanner) throws SQLException {
        DisciplinaService disciplinaService = new DisciplinaService();

        int op;

        do{
            System.out.println("\n===== Menu Disciplina =====");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha a opção desejada: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op){
                case 1 -> {
                    System.out.println("Digite o nome da disciplina: ");
                    String nome = scanner.nextLine();


                    Disciplina disciplina = new Disciplina(nome);

                    if (disciplinaService.inserir(disciplina)) System.out.println("disciplina inserida com sucesso!");
                    else System.out.println("disciplina não foi inserida!");
                }
                case 2 -> {
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
                case 3 ->{
                    ResultSet rs = disciplinaService.listar();
                    try {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id")
                                    + " | Nome: " + rs.getString("nome"));

                        }
                        System.out.println("_______________________");
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar disciplina.");
                    }

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
                case 4 ->{
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

                case 0 -> System.out.println("voltando...");
            }

        }while (op != 0);


    }
}
