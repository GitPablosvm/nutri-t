package com.example.Nutrit.repository;

import com.example.Nutrit.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByNombreUsuario(String nombreUsuario); // Método que verifica si un usuario existe por nombre de usuario
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

}