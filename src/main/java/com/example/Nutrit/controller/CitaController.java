package com.example.Nutrit.controller;

import com.example.Nutrit.dto.CitaDto;
import com.example.Nutrit.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaDto> crearCita(@RequestBody CitaDto citaDto) {
        return new ResponseEntity<>(citaService.crearCita(citaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CitaDto> obtenerTodasLasCitas() {
        return citaService.obtenerTodasLasCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> obtenerCitaPorId(@PathVariable Integer id) {
        CitaDto cita = citaService.obtenerCitaPorId(id);
        return cita != null ? ResponseEntity.ok(cita) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCita(@PathVariable Integer id) {
        return citaService.eliminarCita(id);
    }
}
