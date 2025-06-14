package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Reserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservaDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public ReservaDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM reserva");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Reserva reserva){
        try {
            String SQL = "INSERT INTO reserva(data_hora, id_turno, id_sala_aula, id_turma, id_professor) " + "VALUES (?, ?, ?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setTimestamp(1,java.sql.Timestamp.valueOf(reserva.getDataHora()));
            ps.setInt(2, reserva.getTurno().getId());
            ps.setInt(3, reserva.getSalaDeAula().getId());
            ps.setInt(4, reserva.getTurma().getId());
            ps.setInt(5, reserva.getProfessor().getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir a reserva");
        }
    }

    public void excluir(Reserva reserva){
        try {
            String SQL = "DELETE FROM reserva WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, reserva.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Reserva reserva){
        try {
            String SQL = "UPDATE reserva SET " + "data_hora= ?, id_turno= ?, id_sala_aula= ?, id_turma= ?, id_professor= ?" + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setTimestamp(1,java.sql.Timestamp.valueOf(reserva.getDataHora()));
            ps.setInt(2, reserva.getTurno().getId());
            ps.setInt(3, reserva.getSalaDeAula().getId());
            ps.setInt(4, reserva.getTurma().getId());
            ps.setInt(5, reserva.getProfessor().getId());
            ps.setInt(6,reserva.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet buscarReservasComProfessor() {
        try {
            String SQL = "SELECT r.* FROM reserva r INNER JOIN professor p ON r.id_professor = p.id";
            return conexao.getConn().createStatement().executeQuery(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public ResultSet buscarSalaAulaMaisUtilizada() {
        try {
            String SQL = "select s.nome as sala_nome, count(r.id) as total_reservas from reserva r inner join sala_aula s on r.id_sala_aula = s.id group by s.id, s.nome order by total_reservas desc limit 1";
            return conexao.getConn().createStatement().executeQuery(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarAgendamentos() {
        try {
            String SQL = "select count(*) as total_agendamentos from reserva where date(data_hora) = '2025-07-02';";
            return conexao.getConn().createStatement().executeQuery(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
