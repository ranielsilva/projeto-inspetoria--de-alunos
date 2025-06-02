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
}
