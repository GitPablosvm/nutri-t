package com.example.Nutrit.service;

import com.example.Nutrit.dto.CitaDto;
import com.example.Nutrit.model.Cita;
import com.example.Nutrit.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public CitaDto crearCita(CitaDto citaDto) {
        Cita cita = new Cita();
        cita.setPacienteId(citaDto.getPacienteId());
        cita.setMedicoId(citaDto.getMedicoId());
        cita.setFechaHora(citaDto.getFechaHora());
        cita.setMotivo(citaDto.getMotivo());

        citaRepository.save(cita);
        citaDto.setId(cita.getId());
        return citaDto;
    }

    public List<CitaDto> obtenerTodasLasCitas() {
        return citaRepository.findAll().stream().map(cita -> {
            CitaDto dto = new CitaDto();
            dto.setId(cita.getId());
            dto.setPacienteId(cita.getPacienteId());
            dto.setMedicoId(cita.getMedicoId());
            dto.setFechaHora(cita.getFechaHora());
            dto.setMotivo(cita.getMotivo());
            return dto;
        }).collect(Collectors.toList());
    }

    public CitaDto obtenerCitaPorId(Integer id) {
        return citaRepository.findById(id)
                .map(cita -> {
                    CitaDto dto = new CitaDto();
                    dto.setId(cita.getId());
                    dto.setPacienteId(cita.getPacienteId());
                    dto.setMedicoId(cita.getMedicoId());
                    dto.setFechaHora(cita.getFechaHora());
                    dto.setMotivo(cita.getMotivo());
                    return dto;
                }).orElse(null);
    }

    public ResponseEntity<String> eliminarCita(Integer id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return ResponseEntity.ok("Cita eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
