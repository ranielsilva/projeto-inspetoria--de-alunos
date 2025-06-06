package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Curso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDao {

    private Conexao conexao;
    private PreparedStatement ps;


    public CursoDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM curso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Curso curso){
        try {
            String SQL = "INSERT INTO curso(nome, numero_periodos) " + "VALUES (?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,curso.getNome());
            ps.setInt(2,curso.getNumeroPeriodo());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir o curso");

        }
    }

    public void excluir(Curso curso)  throws SQLException{
        try {
            String SQL = "DELETE FROM curso WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, curso.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Curso curso){
        try {
            String SQL = "UPDATE curso SET " + "nome= ?, numero_periodos= ? " + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getNumeroPeriodo());
            ps.setInt(3, curso.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
