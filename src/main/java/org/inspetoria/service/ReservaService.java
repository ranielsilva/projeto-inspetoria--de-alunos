package org.inspetoria.service;

import org.inspetoria.dao.ReservaDao;
import org.inspetoria.model.Reserva;


import java.sql.ResultSet;

public class ReservaService {
    private ReservaDao reservaDao;

    public ReservaService(){
        reservaDao = new ReservaDao();
    }

    public ResultSet listar(){
        return reservaDao.listar();
    }

    public boolean inserir(Reserva reserva){

        if (!validar(reserva))
            return false;

        reservaDao.inserir(reserva);
        return true;
    }
    public boolean excluir(Reserva reserva){
        if (reserva.getId() == 0)
            return false;

        reservaDao.excluir(reserva);
        return true;
    }

    public boolean editar(Reserva reserva){

        if (!validar(reserva))
            return false;

        reservaDao.editar(reserva);
        return true;
    }

    public boolean validar(Reserva reserva) {
        if (reserva.getDataHora() == null)
            return false;

        if (reserva.getTurno() == null || reserva.getTurno().getId() <= 0)
            return false;

        if (reserva.getSalaDeAula() == null || reserva.getSalaDeAula().getId() <= 0)
            return false;

        if (reserva.getTurma() == null || reserva.getTurma().getId() <= 0)
            return false;

        if (reserva.getProfessor() == null || reserva.getProfessor().getId() <= 0)
            return false;

        return true;
    }
}
