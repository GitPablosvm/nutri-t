package com.example.Nutrit.Seguridad;

import com.example.Nutrit.model.Usuario;
import com.example.Nutrit.model.Rol;
import com.example.Nutrit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class DetallesUsuarios implements UserDetailsService {

    private final UsuarioRepository repositorioUsuario;

    @Autowired
    public DetallesUsuarios(UsuarioRepository repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new User(usuario.getNombreUsuario(), usuario.getContraseña(),
                mapearRolesAAutorizaciones(usuario.getRoles()));
    }

    private Collection<GrantedAuthority> mapearRolesAAutorizaciones(Collection<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre().toUpperCase()))  // Convierte los roles correctamente
                .collect(Collectors.toList());
    }
}


