package com.example.Nutrit.dao;

import com.example.Nutrit.model.NuevoTurno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NuevoTurnoDaoImpl implements NuevoTurnoDao {

    // Injectamos el EntityManager para interactuar con la base de datos
    @PersistenceContext
    private EntityManager entityManager;

    // Método para obtener todos los registros de NuevoTurno
    @Override
    public List<NuevoTurno> getNuevoTurno() {
        // Consulta SQL para obtener todos los turnos
        String query = "FROM NuevoTurno";
        return entityManager.createQuery(query, NuevoTurno.class).getResultList();
    }

    // Método para eliminar un registro por su ID
    @Override
    public void eliminarNuevoTurno(long id) {
        // Buscamos el turno por su ID
        NuevoTurno turno = entityManager.find(NuevoTurno.class, id);
        // Si existe, lo eliminamos
        if (turno != null) {
            entityManager.remove(turno);
        }
    }

    // Método para agregar un nuevo turno
    @Override
    public void agregarNuevoTurno(NuevoTurno nuevoTurno) {
        // Persistimos el nuevo turno en la base de datos
        entityManager.persist(nuevoTurno);
    }
}