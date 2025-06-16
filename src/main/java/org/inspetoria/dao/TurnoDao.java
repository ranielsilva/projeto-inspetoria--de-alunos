package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Turno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TurnoDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public TurnoDao() {
        conexao = new Conexao();
    }

    public ResultSet listar() {
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM turno");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Turno turno) {
        try {
            String SQL = "INSERT INTO turno(nome, hora_inicio, hora_fim) " + "VALUES (?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1, turno.getNome());
            ps.setTime(2, java.sql.Time.valueOf(turno.getHoraInicio()));
            ps.setTime(3, java.sql.Time.valueOf(turno.getHoraFim()));

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir o turno");
        }
    }

    public void excluir(Turno turno) {
        try {
            String SQL = "DELETE FROM turno WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, turno.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Turno turno) {
        try {
            String SQL = "UPDATE turno SET " + "nome= ?, hora_inicio= ?, hora_fim= ?" + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1, turno.getNome());
            ps.setTime(2, java.sql.Time.valueOf(turno.getHoraInicio()));
            ps.setTime(3, java.sql.Time.valueOf(turno.getHoraFim()));
            ps.setInt(4, turno.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
