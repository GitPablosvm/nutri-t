package com.example.Nutrit.controller;

import com.example.Nutrit.dto.SeguimientoDto;
import com.example.Nutrit.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguimientos")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @PostMapping
    public SeguimientoDto registrarSeguimiento(@RequestBody SeguimientoDto seguimientoDto) {
        return seguimientoService.registrarSeguimiento(seguimientoDto);
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<SeguimientoDto> obtenerSeguimientosPorPaciente(@PathVariable Integer idPaciente) {
        return seguimientoService.obtenerSeguimientosPorPaciente(idPaciente);
    }
}
