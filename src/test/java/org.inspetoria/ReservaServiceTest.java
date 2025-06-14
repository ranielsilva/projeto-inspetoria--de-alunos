package org.inspetoria;


import org.inspetoria.service.ReservaService;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {

    @Test
    public void testBuscarReservasComProfessor() throws SQLException {
        ReservaService reservaService = new ReservaService();

        ResultSet rs = reservaService.buscarReservasComProfessor();

        boolean encontrou = false;

        while (rs.next()) {
            int idReserva = rs.getInt("id");
            assertTrue(idReserva > 0, "O ID da reserva deve ser maior que zero.");
            encontrou = true;
            if (encontrou) System.out.println("id da reserva encontrada: " + idReserva);
        }

        assertTrue(encontrou, "Deveria existir pelo menos uma reserva com professor vinculado.");
    }

    @Test
    public void testBuscarSalaAulaMaisUtilizada() {
        ReservaService reservaService = new ReservaService();
        try {
            ResultSet rs = reservaService.buscarSalaAulaMaisUtilizada();

            assertTrue(rs.next(), "Nenhum resultado encontrado.");

            String nomeSala = rs.getString("sala_nome");
            int totalReservas = rs.getInt("total_reservas");

            System.out.println("Sala mais utilizada: " + nomeSala + " | número de reservas " + totalReservas);

            assertNotNull(nomeSala, "nome da sala não pode ser nulo.");
            assertTrue(totalReservas > 0, "o total de reservas deve ser maior que zero.");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao executar consulta: " + e.getMessage());
        }

    }

    @Test
    public void buscarAgendamentos() {
        ReservaService reservaService = new ReservaService();
        try {
            ResultSet rs = reservaService.buscarAgendamentos();

            assertTrue(rs.next(), "Nenhum resultado encontrado.");

            int totalAgendamentos = rs.getInt("total_agendamentos");

            System.out.println("total de agendamentos: " + totalAgendamentos);

           assertTrue(totalAgendamentos > 0, "o total de agendamentos deve ser maior que zero.");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Erro ao executar consulta: " + e.getMessage());
        }

    }
}
