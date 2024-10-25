package com.example.Nutrit.service;

import com.example.Nutrit.model.UsuarioDto;
import com.example.Nutrit.Seguridad.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuariosRepositorio usuariosRepositorio;

    @Autowired
    public UsuarioService(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    public List<UsuarioDto> obtenerTodos() {
        return usuariosRepositorio.findAll().stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }

    public UsuarioDto obtenerPorId(Integer id) {
        return usuariosRepositorio.findById(id)
                .map(UsuarioDto::new)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
