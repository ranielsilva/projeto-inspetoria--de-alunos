package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Turma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public TurmaDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM turma");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Turma turma){
        try {
            String SQL = "INSERT INTO turma(codigo, id_professor, id_disciplina, id_periodo, id_curso) " + "VALUES (?, ?, ?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,turma.getCodigo());
            ps.setInt(2, turma.getProfessor().getId());
            ps.setInt(3, turma.getDisciplina().getId());
            ps.setInt(4, turma.getPeriodo().getId());
            ps.setInt(5, turma.getCurso().getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir a turma");
        }
    }

    public void excluir(Turma turma){
        try {
            String SQL = "DELETE FROM turma WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, turma.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Turma turma){
        try {
            String SQL = "UPDATE turma SET " + "codigo= ?, id_professor= ?, id_disciplina= ?, id_periodo= ?, id_curso= ?" + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,turma.getCodigo());
            ps.setInt(2, turma.getProfessor().getId());
            ps.setInt(3, turma.getDisciplina().getId());
            ps.setInt(4, turma.getPeriodo().getId());
            ps.setInt(5, turma.getCurso().getId());
            ps.setInt(6,turma.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
