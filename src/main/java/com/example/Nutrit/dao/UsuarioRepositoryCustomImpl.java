package com.example.Nutrit.dao;

import com.example.Nutrit.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        return entityManager.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public List<Usuario> getUsuariosPorRol(String rol) {
        return entityManager.createQuery(
                        "SELECT u FROM Usuario u JOIN u.cuentaUsuario c WHERE c.rol = :rol", Usuario.class)
                .setParameter("rol", rol)
                .getResultList();
    }
}