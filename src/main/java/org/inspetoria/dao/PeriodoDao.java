package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Periodo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodoDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public PeriodoDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM periodo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Periodo periodo){
        try {
            String SQL = "INSERT INTO periodo(nome, ano, semestre) " + "VALUES (?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,periodo.getNome());
            ps.setInt(2,periodo.getAno());
            ps.setInt(3,periodo.getSemestre());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir o periodo");
        }
    }

    public void excluir(Periodo periodo){
        try {
            String SQL = "DELETE FROM periodo WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, periodo.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Periodo periodo){
        try {
            String SQL = "UPDATE periodo SET " + "nome= ?, ano= ?, semestre= ? " + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1, periodo.getNome());
            ps.setInt(2, periodo.getAno());
            ps.setInt(3, periodo.getSemestre());
            ps.setInt(4, periodo.getId());


            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
