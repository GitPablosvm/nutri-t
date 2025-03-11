package com.example.Nutrit.service;

import com.example.Nutrit.dto.RegistroDto;
import com.example.Nutrit.dto.UsuarioDto;
import com.example.Nutrit.model.Medico;
import com.example.Nutrit.model.Paciente;
import com.example.Nutrit.model.Usuario;
import com.example.Nutrit.repository.MedicoRepository;
import com.example.Nutrit.repository.PacienteRepository;
import com.example.Nutrit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registrarUsuario(RegistroDto registroDto) {
        // Verificar si el nombre de usuario ya existe
        if (usuarioRepository.existsByNombreUsuario(registroDto.getNombreUsuario())) {
            return "El nombre de usuario ya está en uso.";
        }

        // Asignar rol por defecto "PACIENTE" si no se especifica
        String rol = registroDto.getRol();
        if (rol == null || rol.trim().isEmpty()) {
            rol = "PACIENTE";
        }

        // Crear nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(registroDto.getNombreUsuario());
        usuario.setEmail(registroDto.getEmail());
        usuario.setContraseña(passwordEncoder.encode(registroDto.getContraseña()));

        // Guardar usuario
        usuarioRepository.save(usuario);

        // Crear entidad específica según el rol asignado
        if ("PACIENTE".equalsIgnoreCase(rol)) {
            Paciente paciente = new Paciente();
            paciente.setUsuario(usuario);
            paciente.setObraSocial(registroDto.getObraSocial());
            paciente.setAltura(registroDto.getAltura());
            paciente.setPesoInicial(registroDto.getPesoInicial());
            paciente.setPesoObjetivo(registroDto.getPesoObjetivo());
            pacienteRepository.save(paciente);
        } else if ("MEDICO".equalsIgnoreCase(rol)) {
            Medico medico = new Medico();
            medico.setUsuario(usuario);
            medico.setEspecialidad(registroDto.getEspecialidad());
            medico.setMatricula(registroDto.getMatricula());
            medicoRepository.save(medico);
        }

        return "Registro exitoso.";
    }

    public List<UsuarioDto> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNombreUsuario(),
                        usuario.getEmail(),
                        usuario.getRoles().toString()))
                .collect(Collectors.toList());
    }

    public UsuarioDto obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNombreUsuario(),
                        usuario.getEmail(),
                        usuario.getRoles().toString()))
                .orElse(null);
    }

    public List<UsuarioDto> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll().stream()
                .map(paciente -> new UsuarioDto(
                        paciente.getUsuario().getId(),
                        paciente.getUsuario().getNombreUsuario(),
                        paciente.getUsuario().getEmail(),
                        "PACIENTE"))
                .collect(Collectors.toList());
    }

    public List<UsuarioDto> obtenerTodosLosMedicos() {
        return medicoRepository.findAll().stream()
                .map(medico -> new UsuarioDto(
                        medico.getUsuario().getId(),
                        medico.getUsuario().getNombreUsuario(),
                        medico.getUsuario().getEmail(),
                        "MEDICO"))
                .collect(Collectors.toList());
    }
}

