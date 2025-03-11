package com.example.Nutrit.controller;

import com.example.Nutrit.dto.UsuarioDto;
import com.example.Nutrit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDto obtenerUsuarioPorId(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/pacientes")
    public List<UsuarioDto> obtenerPacientes() {
        return usuarioService.obtenerTodosLosPacientes();
    }

    @GetMapping("/medicos")
    public List<UsuarioDto> obtenerMedicos() {
        return usuarioService.obtenerTodosLosMedicos();
    }
}


