package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Disciplina;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplinaDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public DisciplinaDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM disciplina");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Disciplina disciplina){
        try {
            String SQL = "INSERT INTO disciplina(nome) " + "VALUES (?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,disciplina.getNome());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir a disciplina");
        }
    }

    public void excluir(Disciplina disciplina){
        try {
            String SQL = "DELETE FROM disciplina WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, disciplina.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Disciplina disciplina){
        try {
            String SQL = "UPDATE disciplina SET " + "nome= ? " + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
