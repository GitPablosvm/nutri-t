package com.example.Nutrit.Seguridad;

import com.example.Nutrit.model.Rol;
import com.example.Nutrit.model.Roles;
import com.example.Nutrit.model.UsuariosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetallesUsuarios  implements UserDetailsService{

    private UsuariosRepositorio usuariosRepositorio;
    @Autowired
    public DetallesUsuarios(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosEntity usuarios = usuariosRepositorio.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario incorrecto"));
        return new User(usuarios.getUsername(), usuarios.getPassword(), mapRolesToAuthorities(usuarios.getRoles()));
    }



    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
    }
}
