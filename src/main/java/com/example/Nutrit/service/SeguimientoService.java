package com.example.Nutrit.service;

import com.example.Nutrit.dto.SeguimientoDto;
import com.example.Nutrit.model.Paciente;
import com.example.Nutrit.model.Seguimiento;
import com.example.Nutrit.repository.PacienteRepository;
import com.example.Nutrit.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public SeguimientoDto registrarSeguimiento(SeguimientoDto dto) {
        Seguimiento seguimiento = new Seguimiento();
        // Convertir pacienteId en objeto Paciente
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        seguimiento.setPaciente(paciente);
        seguimiento.setFecha(dto.getFecha());
        seguimiento.setPesoActual(dto.getPesoActual());
        seguimiento.setObservaciones(dto.getObservaciones());
        seguimientoRepository.save(seguimiento);
        dto.setId(seguimiento.getId());
        return dto;
    }

    public List<SeguimientoDto> obtenerSeguimientosPorPaciente(Integer idPaciente) {
        return seguimientoRepository.findByPacienteId(idPaciente).stream().map(seguimiento -> {
            SeguimientoDto dto = new SeguimientoDto();
            dto.setId(seguimiento.getId());
            dto.setFecha(seguimiento.getFecha());
            dto.setPesoActual(seguimiento.getPesoActual());
            dto.setObservaciones(seguimiento.getObservaciones());
            dto.setPacienteId(seguimiento.getPaciente().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}

