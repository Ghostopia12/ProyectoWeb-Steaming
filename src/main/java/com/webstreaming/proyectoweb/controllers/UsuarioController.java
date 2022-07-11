package com.webstreaming.proyectoweb.controllers;

import com.webstreaming.proyectoweb.models.Series;
import com.webstreaming.proyectoweb.models.Usuario;
import com.webstreaming.proyectoweb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public  UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    /*@GetMapping("admin/{usuarioId}")
    public ResponseEntity<Usuario> getAdminById(@PathVariable Integer usuarioId){
        Usuario user = usuarioRepository.findByUsuarioId(usuarioId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }*/

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer usuarioId){
        Usuario user = usuarioRepository.findByUsuarioId(usuarioId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    //POST/api/usuario/login
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario loginUser){
        Usuario storedUser = usuarioRepository.findByUserName(loginUser.getUserName());
        if(storedUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(storedUser.getContra().equals(loginUser.getContra())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        storedUser.setContra("");
        return ResponseEntity.ok(storedUser);
    }
    @PostMapping("/register")
    public ResponseEntity<Usuario> insertContacto(@RequestBody Usuario obj){
        Usuario usuario =  usuarioRepository.findByUsuarioId(obj.getUsuarioId());
        obj =usuarioRepository.save(obj);
        return ResponseEntity.ok(obj);
    }
    @PostMapping()
    public ResponseEntity<Usuario> registerUser(@RequestBody Usuario loginUser){
        Usuario storedUser = usuarioRepository.findByUserName(loginUser.getUserName());
        if(storedUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(storedUser.getContra().equals(loginUser.getContra())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        storedUser.setContra("");
        return ResponseEntity.ok(storedUser);
    }
}
