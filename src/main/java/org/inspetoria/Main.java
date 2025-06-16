package org.inspetoria;

import org.inspetoria.ui.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int op = -1;

        do {
            try {

                System.out.println("===== MENU PRINCIPAL =====");
                System.out.println("1. Curso");
                System.out.println("2. Disciplina");
                System.out.println("3. Periodo");
                System.out.println("4. Professor");
                System.out.println("5. Reserva");
                System.out.println("6. Sala De Aula");
                System.out.println("7. Turma");
                System.out.println("8. Turno    ");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> MenuCurso.menu(scanner);
                    case 2 -> MenuDisciplina.menu(scanner);
                    case 3 -> MenuPeriodo.menu(scanner);
                    case 4 -> MenuProfessor.menu(scanner);
                    case 5 -> MenuReserva.menu(scanner);
                    case 6 -> MenuSalaDeAula.menu(scanner);
                    case 7 -> MenuTurma.menu(scanner);
                    case 8 -> MenuTurno.menu(scanner);

                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida!");

                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione uma opção válida");
                scanner.nextLine();
            }
        } while (op != 0);

    }
}
