package com.example.Nutrit.service;

import com.example.Nutrit.dto.PacienteDto;
import com.example.Nutrit.model.Paciente;
import com.example.Nutrit.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDto> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll().stream().map(paciente -> {
            PacienteDto dto = new PacienteDto();
            dto.setId(paciente.getId());
            dto.setNombre(paciente.getUsuario().getNombreUsuario());
            dto.setObraSocial(paciente.getObraSocial());
            dto.setAltura(paciente.getAltura());
            dto.setPesoInicial(paciente.getPesoInicial());
            dto.setPesoObjetivo(paciente.getPesoObjetivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public PacienteDto obtenerPacientePorId(Integer id) {
        return pacienteRepository.findById(id).map(paciente -> {
            PacienteDto dto = new PacienteDto();
            dto.setId(paciente.getId());
            dto.setNombre(paciente.getUsuario().getNombreUsuario());
            dto.setObraSocial(paciente.getObraSocial());
            dto.setAltura(paciente.getAltura());
            dto.setPesoInicial(paciente.getPesoInicial());
            dto.setPesoObjetivo(paciente.getPesoObjetivo());
            return dto;
        }).orElse(null);
    }

    public PacienteDto actualizarPaciente(Integer id, PacienteDto pacienteDto) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            paciente.setObraSocial(pacienteDto.getObraSocial());
            paciente.setAltura(pacienteDto.getAltura());
            paciente.setPesoInicial(pacienteDto.getPesoInicial());
            paciente.setPesoObjetivo(pacienteDto.getPesoObjetivo());
            pacienteRepository.save(paciente);
        }
        return pacienteDto;
    }
}
