package com.amaral.cadastrousuarios.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.cadastrousuarios.repository.UsuarioRepository;
import com.amaral.cadastrousuarios.entity.Usuarios;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
// @CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuarios> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUserById(@PathVariable(value = "id") Integer id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent())
            return new ResponseEntity<Usuarios>(usuario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Usuarios addUsuario(@RequestBody Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Integer id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}
