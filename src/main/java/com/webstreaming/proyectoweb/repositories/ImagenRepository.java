package com.webstreaming.proyectoweb.repositories;

import com.webstreaming.proyectoweb.models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen,Integer> {
    Imagen findByImagenId(Integer imagenId);
}
