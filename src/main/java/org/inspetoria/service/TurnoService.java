package org.inspetoria.service;

import org.inspetoria.dao.TurnoDao;
import org.inspetoria.model.Turno;

import java.sql.ResultSet;

public class TurnoService {
    private TurnoDao turnoDao;

    public TurnoService(){
        turnoDao = new TurnoDao();
    }

    public ResultSet listar(){
        return turnoDao.listar();
    }

    public boolean inserir(Turno turno){

        if (!validar(turno))
            return false;

        turnoDao.inserir(turno);
        return true;
    }
    public boolean excluir(Turno turno){
        if (turno.getId() == 0)
            return false;

        turnoDao.excluir(turno);
        return true;
    }

    public boolean editar(Turno turno){

        if (!validar(turno))
            return false;

        turnoDao.editar(turno);
        return true;
    }

    public boolean validar(Turno turno) {
        if (turno.getNome() == null || turno.getNome().trim().isEmpty())
            return false;

        if (turno.getHoraInicio() == null || turno.getHoraFim() == null)
            return false;

        if (!turno.getHoraFim().isAfter(turno.getHoraInicio()))
            return false;

        return true;
    }
}
