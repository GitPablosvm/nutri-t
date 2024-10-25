package com.example.Nutrit.controller;

import com.example.Nutrit.model.UsuarioDto;
import com.example.Nutrit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDto> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDto obtenerPorId(@PathVariable Integer id) {
        return usuarioService.obtenerPorId(id);
    }
}


