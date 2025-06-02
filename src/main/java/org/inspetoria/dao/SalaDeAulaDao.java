package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.SalaDeAula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaDeAulaDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public SalaDeAulaDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM sala_aula");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(SalaDeAula salaDeAula){
        try {
            String SQL = "INSERT INTO sala_aula(nome, capacidade, localizacao) " + "VALUES (?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,salaDeAula.getNome());
            ps.setInt(2,salaDeAula.getCapacidade());
            ps.setString(3,salaDeAula.getLocalizacao());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir a sala de aula");
        }
    }

    public void excluir(SalaDeAula salaDeAula){
        try {
            String SQL = "DELETE FROM sala_aula WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, salaDeAula.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(SalaDeAula salaDeAula){
        try {
            String SQL = "UPDATE sala_aula SET " + "nome= ?, capacidade= ?, localizacao= ?" + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,salaDeAula.getNome());
            ps.setInt(2,salaDeAula.getCapacidade());
            ps.setString(3,salaDeAula.getLocalizacao());
            ps.setInt(4,salaDeAula.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
