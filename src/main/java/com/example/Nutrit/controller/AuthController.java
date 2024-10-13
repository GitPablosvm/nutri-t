package com.example.Nutrit.controller;


import com.example.Nutrit.Seguridad.RolesRepositorio;
import com.example.Nutrit.Seguridad.UsuariosRepositorio;
import com.example.Nutrit.model.RegistroDto;
import com.example.Nutrit.model.Rol;
import com.example.Nutrit.model.Roles;
import com.example.Nutrit.model.UsuariosEntity;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UsuariosRepositorio usuariosRepositorio;
    private RolesRepositorio rolesRepositorio;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UsuariosRepositorio usuariosRepositorio,
                          RolesRepositorio rolesRepositorio, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuariosRepositorio = usuariosRepositorio;
        this.rolesRepositorio = rolesRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody RegistroDto registroDto){
        if(usuariosRepositorio.existsByUsername(registroDto.getUsername())) {
        return new ResponseEntity<>("Usuario Correcto", HttpStatus.BAD_REQUEST);
        }
        UsuariosEntity user = new UsuariosEntity();
        user.setUsername(registroDto.getUsername());
        user.setPassword(passwordEncoder.encode(registroDto.getPassword()));

        Roles roles = rolesRepositorio.findByName("USUARIO").get();
        user.setRoles(Collections.singletonList(roles));

        usuariosRepositorio.save(user);

        return new ResponseEntity<>("Registro de Usuario Completo", HttpStatus.OK);


    }

}
