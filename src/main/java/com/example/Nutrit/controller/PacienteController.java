package com.example.Nutrit.controller;

import com.example.Nutrit.dto.PacienteDto;
import com.example.Nutrit.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDto> obtenerTodosLosPacientes() {
        return pacienteService.obtenerTodosLosPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDto obtenerPacientePorId(@PathVariable Integer id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    @PutMapping("/{id}")
    public PacienteDto actualizarPaciente(@PathVariable Integer id, @RequestBody PacienteDto pacienteDto) {
        return pacienteService.actualizarPaciente(id, pacienteDto);
    }
}
