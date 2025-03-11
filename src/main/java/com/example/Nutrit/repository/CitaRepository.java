package com.example.Nutrit.repository;

import com.example.Nutrit.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    // Obtener todas las citas de un paciente específico
    List<Cita> findByPacienteId(Integer pacienteId);

    // Obtener todas las citas de un médico específico
    List<Cita> findByMedicoId(Integer medicoId);

    // Buscar citas en un rango de fechas
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
}
