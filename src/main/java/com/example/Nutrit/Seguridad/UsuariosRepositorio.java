package com.example.Nutrit.Seguridad;


import com.example.Nutrit.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepositorio extends JpaRepository<UsuariosEntity, Integer> {
    Optional<UsuariosEntity> findByUsername(String username);
    Boolean existsByUsername (String username);

}
