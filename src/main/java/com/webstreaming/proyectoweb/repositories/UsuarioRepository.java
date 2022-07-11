package com.webstreaming.proyectoweb.repositories;

import com.webstreaming.proyectoweb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByUsuarioId(Integer usuarioId);
    Usuario findByUserName(String userName);
}
