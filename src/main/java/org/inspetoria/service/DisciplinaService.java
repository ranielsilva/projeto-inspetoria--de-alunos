package org.inspetoria.service;

import org.inspetoria.dao.DisciplinaDao;
import org.inspetoria.model.Disciplina;

import java.sql.ResultSet;

public class DisciplinaService {
    private DisciplinaDao disciplinaDao;

    public DisciplinaService(){
        disciplinaDao = new DisciplinaDao();
    }

    public ResultSet listar(){
        return disciplinaDao.listar();
    }

    public boolean inserir(Disciplina disciplina){

        if (!validar(disciplina))
            return false;

        disciplinaDao.inserir(disciplina);
        return true;
    }
    public boolean excluir(Disciplina disciplina){
        if (disciplina.getId() == 0)
            return false;

        disciplinaDao.excluir(disciplina);
        return true;
    }

    public boolean editar(Disciplina disciplina){

        if (!validar(disciplina))
            return false;

        disciplinaDao.editar(disciplina);
        return true;
    }

    public boolean validar(Disciplina disciplina){
        if (disciplina.getNome() == null || disciplina.getNome().trim().isEmpty())
            return false;

        return true;
    }
}
