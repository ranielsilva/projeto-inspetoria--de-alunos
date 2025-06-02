package org.inspetoria.service;

import org.inspetoria.dao.ProfessorDao;
import org.inspetoria.model.Professor;

import java.sql.ResultSet;

public class ProfessorService {
    private ProfessorDao professorDao;

    public ProfessorService(){
        professorDao = new ProfessorDao();
    }

    public ResultSet listar(){
        return professorDao.listar();
    }

    public boolean inserir(Professor professor){

        if (!validar(professor))
            return false;

        professorDao.inserir(professor);
        return true;
    }
    public boolean excluir(Professor professor){
        if (professor.getId() == 0)
            return false;

        professorDao.excluir(professor);
        return true;
    }

    public boolean editar(Professor professor){

        if (!validar(professor))
            return false;

        professorDao.editar(professor);
        return true;
    }

    public boolean validar(Professor professor) {
        if (professor.getNome() == null || professor.getNome().trim().isEmpty())
            return false;

        if (professor.getDataNascimento() == null)
            return false;

        if (professor.getCpf() == null || professor.getCpf().trim().isEmpty())
            return false;

        if (professor.getEmail() == null || professor.getEmail().trim().isEmpty())
            return false;

        if (professor.getEndereco() == null || professor.getEndereco().trim().isEmpty())
            return false;

        if (professor.getTelefone() == null || professor.getTelefone().trim().isEmpty())
            return false;

        return true;
    }
}
