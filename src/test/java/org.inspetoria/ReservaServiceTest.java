import org.inspetoria.service.ReservaService;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {
    /**
     * 📌 Título: Retornar dados do professor que efetuou uma reserva.
     *
     * 📋 Entidades Envolvidas:
     * - Reserva
     * - Professor
     *
     * 🎯 Objetivo:
     * Verificar se o método buscarReservasComProfessor() retorna reservas que
     * possuem um professor vunculado.
     *
     * 📝 Descrição:
     * Este teste verifica os resultados retornados pela consulta no banco de dados,
     * verificando se cada reserva tem um ID válido e se ao menos uma reserva foi
     * encontrada.
     *
     * ✅ Saída Esperada:
     * ID da reserva com professor.
     *
     * 🔗 Dependências:
     * - Deve existir pelo menos uma reserva com professor cadastrado no banco.
     */
    @Test
    public void testBuscarReservasComProfessor() throws SQLException {
        ReservaService reservaService = new ReservaService();

        ResultSet rs = reservaService.buscarReservasComProfessor();

        boolean encontrou = false;

        while (rs.next()) {
            int idReserva = rs.getInt("id");
            assertTrue(idReserva > 0, "O ID da reserva deve ser maior que zero.");
            encontrou = true;
            if (encontrou)
                System.out.println("id da reserva encontrada: " + idReserva);
        }

        assertTrue(encontrou, "Deveria existir pelo menos uma reserva com professor vinculado.");
    }

    /**
     * 📌 Título: Retornar qual a sala de aula mais utilizada.
     *
     * 📋 Entidades Envolvidas:
     * - Reserva
     * - SalaAula
     *
     * 🎯 Objetivo:
     * Validar se o método buscarSalaAulaMaisUtilizada() retorna a sala com o maior
     * número de reservas.
     *
     * 📝 Descrição:
     * Executa a consulta SQL que calcula a sala mais utilizada com base na contagem
     * de reservas.
     *
     * ✅ Saída Esperada:
     * Uma linha com o nome da sala e o número de reservas maior que zero.
     *
     * 🔗 Dependências:
     * - É necessário ter pelo menos uma reserva no banco vinculada a uma sala de
     * aula.
     */
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

    /**
     * 📌 Título: Retornar a quantidade de agendamentos em um determinado dia.
     *
     * 📋 Entidades Envolvidas:
     * - Reserva
     *
     * 🎯 Objetivo:
     * Verificar se o método buscarAgendamentos() retorna corretamente o total de
     * agendamentos para a data consultada.
     *
     * 📝 Descrição:
     * Executa a consulta que conta o número de reservas agendadas para uma data
     * específica.
     *
     * ✅ Saída Esperada:
     * Total de agendamentos em um determinado dia.
     *
     * 🔗 Dependências:
     * - Deve existir pelo menos uma reserva na data que foi definida na consulta da
     * Query do sql.
     * - A data usada para consulta não pode ser nula.
     */
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
