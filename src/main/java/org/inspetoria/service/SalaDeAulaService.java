package org.inspetoria.service;

import org.inspetoria.dao.SalaDeAulaDao;
import org.inspetoria.model.SalaDeAula;

import java.sql.ResultSet;

public class SalaDeAulaService {
    private SalaDeAulaDao salaDeAulaDao;

    public SalaDeAulaService(){
        salaDeAulaDao = new SalaDeAulaDao();
    }

    public ResultSet listar(){
        return salaDeAulaDao.listar();
    }

    public boolean inserir(SalaDeAula salaDeAula){

        if (!validar(salaDeAula))
            return false;

        salaDeAulaDao.inserir(salaDeAula);
        return true;
    }
    public boolean excluir(SalaDeAula salaDeAula){
        if (salaDeAula.getId() == 0)
            return false;

        salaDeAulaDao.excluir(salaDeAula);
        return true;
    }

    public boolean editar(SalaDeAula salaDeAula){

        if (!validar(salaDeAula))
            return false;

        salaDeAulaDao.editar(salaDeAula);
        return true;
    }

    public boolean validar(SalaDeAula salaDeAula) {
        if (salaDeAula.getNome() == null || salaDeAula.getNome().trim().isEmpty())
            return false;

        if (salaDeAula.getCapacidade() <= 0 || salaDeAula.getCapacidade() <= 0)
            return false;

        if (salaDeAula.getLocalizacao() == null || salaDeAula.getLocalizacao().trim().isEmpty())
            return false;

        return true;
    }
}
