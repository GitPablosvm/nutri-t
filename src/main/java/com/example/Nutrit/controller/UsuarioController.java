package com.example.Nutrit.controller;

import java.util.List;

import com.example.Nutrit.dao.UsuarioDao;
import com.example.Nutrit.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class UsuarioController {

        @Autowired
        private UsuarioDao usuarioDao;

        /*metodo para mostrar un usuario*/

        @RequestMapping(value="api/usuarios")
        public List<Usuarios> getUsuarios(){

            List<Usuarios> user=usuarioDao.getUsuarios();

            return user;
        }

        /*Metodo para elimienar un usuario*/

        @RequestMapping(value="api/usuarios/{id}", method=RequestMethod.DELETE)
        public void eliminarUsuario(@PathVariable Long id){

            usuarioDao.eliminarUsuario(id);
        }

        /* Registra los usuarios en la tabla*/

        @RequestMapping(value="api/usuarios", method=RequestMethod.POST)
        public void registrarUsuario(@RequestBody Usuarios usuario){

            usuarioDao.registrar(usuario);
        }

}
