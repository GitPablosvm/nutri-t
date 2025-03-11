package com.example.Nutrit.controller;

import com.example.Nutrit.dto.MedicoDto;
import com.example.Nutrit.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoDto> obtenerTodosLosMedicos() {
        return medicoService.obtenerTodosLosMedicos();
    }

    @GetMapping("/{id}")
    public MedicoDto obtenerMedicoPorId(@PathVariable Integer id) {
        return medicoService.obtenerMedicoPorId(id);
    }
}
