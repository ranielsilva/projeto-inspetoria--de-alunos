package org.inspetoria.service;

import org.inspetoria.dao.CursoDao;
import org.inspetoria.model.Curso;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoService {
    private CursoDao cursoDao;

    public CursoService(){

        cursoDao = new CursoDao();
    }

    public ResultSet listar(){
        return cursoDao.listar();
    }

    public boolean inserir(Curso curso){

        if (!validar(curso))
            return false;

        cursoDao.inserir(curso);
        return true;
    }
    public boolean excluir(Curso curso)  throws SQLException {
        if (curso.getId() == 0)
            return false;

        cursoDao.excluir(curso);
        return true;
    }

    public boolean editar(Curso curso){

        if (!validar(curso))
            return false;

        cursoDao.editar(curso);
        return true;
    }

    public boolean validar(Curso curso){
        if (curso.getNome() == null || curso.getNome().trim().isEmpty())
            return false;

        if (curso.getNumeroPeriodo() <= 0)
            return false;

        return true;
    }
}
