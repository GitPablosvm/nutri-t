package com.example.Nutrit.service;

import com.example.Nutrit.dto.MedicoDto;
import com.example.Nutrit.model.Medico;
import com.example.Nutrit.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoDto> obtenerTodosLosMedicos() {
        return medicoRepository.findAll().stream().map(medico -> {
            MedicoDto dto = new MedicoDto();
            dto.setId(medico.getId());
            dto.setNombre(medico.getUsuario().getNombreUsuario());
            dto.setEspecialidad(medico.getEspecialidad());
            dto.setMatricula(medico.getMatricula());
            return dto;
        }).collect(Collectors.toList());
    }

    public MedicoDto obtenerMedicoPorId(Integer id) {
        return medicoRepository.findById(id).map(medico -> {
            MedicoDto dto = new MedicoDto();
            dto.setId(medico.getId());
            dto.setNombre(medico.getUsuario().getNombreUsuario());
            dto.setEspecialidad(medico.getEspecialidad());
            dto.setMatricula(medico.getMatricula());
            return dto;
        }).orElse(null);
    }
}
