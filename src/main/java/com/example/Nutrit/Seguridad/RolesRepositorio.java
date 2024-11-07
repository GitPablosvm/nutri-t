package com.example.Nutrit.Seguridad;

import com.example.Nutrit.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepositorio extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(String name);

}
