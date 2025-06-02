package org.inspetoria.service;

import org.inspetoria.dao.TurmaDao;
import org.inspetoria.model.Turma;


import java.sql.ResultSet;

public class TurmaService {
    private TurmaDao turmaDao;

    public TurmaService(){
        turmaDao = new TurmaDao();
    }

    public ResultSet listar(){
        return turmaDao.listar();
    }

    public boolean inserir(Turma turma){

        if (!validar(turma))
            return false;

        turmaDao.inserir(turma);
        return true;
    }
    public boolean excluir(Turma turma){
        if (turma.getId() == 0)
            return false;

        turmaDao.excluir(turma);
        return true;
    }

    public boolean editar(Turma turma){

        if (!validar(turma))
            return false;

        turmaDao.editar(turma);
        return true;
    }

    public boolean validar(Turma turma) {
        if (turma.getCodigo() == null || turma.getCodigo().trim().isEmpty())
            return false;

        if (turma.getProfessor() == null || turma.getProfessor().getId() <= 0)
            return false;

        if (turma.getDisciplina() == null || turma.getDisciplina().getId() <= 0)
            return false;

        if (turma.getPeriodo() == null || turma.getPeriodo().getId() <= 0)
            return false;

        if (turma.getCurso() == null || turma.getCurso().getId() <= 0)
            return false;

        return true;
    }
}
