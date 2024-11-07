package com.example.Nutrit.dao;

import com.example.Nutrit.model.NuevoTurno;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface NuevoTurnoDao {

    List<NuevoTurno> getNuevoTurno();
    void eliminarNuevoTurno(long id );
    void agregarNuevoTurno(NuevoTurno nuevoTurno);
}
