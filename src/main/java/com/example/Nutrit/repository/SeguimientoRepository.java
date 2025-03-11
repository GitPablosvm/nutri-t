package com.example.Nutrit.repository;

import com.example.Nutrit.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {

    // Obtener todos los seguimientos de un paciente
    List<Seguimiento> findByPacienteId(Integer pacienteId);

    // Obtener el último seguimiento de un paciente
    Seguimiento findTopByPacienteIdOrderByFechaDesc(Integer pacienteId);
}
