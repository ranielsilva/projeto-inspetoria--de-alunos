package org.inspetoria.dao;

import org.inspetoria.conf.Conexao;
import org.inspetoria.model.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDao {
    private Conexao conexao;
    private PreparedStatement ps;

    public ProfessorDao(){
        conexao = new Conexao();
    }

    public ResultSet listar(){
        try {
            return conexao.getConn().createStatement().executeQuery("SELECT * FROM professor");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void inserir(Professor professor){
        try {
            String SQL = "INSERT INTO professor(nome, data_nascimento, cpf, endereco, email,  telefone) " + "VALUES (?, ?, ?, ?, ?, ?)";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,professor.getNome());
            ps.setDate(2,java.sql.Date.valueOf(professor.getDataNascimento()));
            ps.setString(3,professor.getCpf());
            ps.setString(4,professor.getEndereco());
            ps.setString(5,professor.getEmail());
            ps.setString(6,professor.getTelefone());



            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ocorreu um erro ao inserir o professor");
        }
    }

    public void excluir(Professor professor){
        try {
            String SQL = "DELETE FROM professor WHERE id = ?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setInt(1, professor.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editar(Professor professor){
        try {
            String SQL = "UPDATE professor SET " + "nome= ?, data_nascimento= ?, cpf= ?,endereco= ?, email= ?, telefone= ?" + "WHERE id=?";

            ps = conexao.getConn().prepareStatement(SQL);

            ps.setString(1,professor.getNome());
            ps.setDate(2,java.sql.Date.valueOf(professor.getDataNascimento()));
            ps.setString(3,professor.getCpf());
            ps.setString(4,professor.getEndereco());
            ps.setString(5,professor.getEmail());
            ps.setString(6,professor.getTelefone());
            ps.setInt(7,professor.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
