package org.inspetoria.service;

import org.inspetoria.dao.PeriodoDao;
import org.inspetoria.model.Periodo;

import java.sql.ResultSet;

public class PeriodoService {
    private PeriodoDao periodoDao;

    public PeriodoService(){
        periodoDao = new PeriodoDao();
    }

    public ResultSet listar(){
        return periodoDao.listar();
    }

    public boolean inserir(Periodo periodo){

        if (!validar(periodo))
            return false;

        periodoDao.inserir(periodo);
        return true;
    }
    public boolean excluir(Periodo periodo){
        if (periodo.getId() == 0)
            return false;

        periodoDao.excluir(periodo);
        return true;
    }

    public boolean editar(Periodo periodo){

        if (!validar(periodo))
            return false;

        periodoDao.editar(periodo);
        return true;
    }

    public boolean validar(Periodo periodo){
        if (periodo.getNome() == null || periodo.getNome().trim().isEmpty())
            return false;

        if (periodo.getAno() <= 0 || periodo.getSemestre() <= 0)
            return false;

        return true;
    }
}
