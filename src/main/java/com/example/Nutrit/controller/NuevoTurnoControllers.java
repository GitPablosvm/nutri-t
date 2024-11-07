package com.example.Nutrit.controller;


import com.example.Nutrit.dao.NuevoTurnoDao;
import com.example.Nutrit.model.NuevoTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NuevoTurnoControllers {

    @Autowired
    private NuevoTurnoDao nuevoTurnoDao;

    @GetMapping(value = "api/nuevoTurno")
    public List<NuevoTurno> getNuevoTurno() {
        List<NuevoTurno> nuevoTurno = nuevoTurnoDao.getNuevoTurno();
        return nuevoTurno;
    }

    @DeleteMapping(value = "api/nuevoTurno/{id}")
    public void eliminarNuevoTurno(@PathVariable long id) {
        nuevoTurnoDao.eliminarNuevoTurno(id);
}


    @PostMapping(value = "api/nuevoTurno")
    public void agregarNuevoTurno(@RequestBody NuevoTurno nuevoTurno) {
        nuevoTurnoDao.agregarNuevoTurno(nuevoTurno);
}

}
