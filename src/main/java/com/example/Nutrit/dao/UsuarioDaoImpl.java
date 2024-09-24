package com.example.Nutrit.dao;

import java.util.List;
import com.example.Nutrit.model.Usuarios;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
    public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings(value = "unchecked")
    @Override
    public List<Usuarios> getUsuarios() {

        String query="from Usuarios";

        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void eliminarUsuario(Long id) {
        Usuarios usuario = entityManager.find(Usuarios.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public void registrar(Usuarios usuario) {
        entityManager.persist(usuario);
    }
}
