package com.webstreaming.proyectoweb.repositories;

import com.webstreaming.proyectoweb.models.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporadaRepository extends JpaRepository<Temporada,Integer> {
    Temporada findByTemporadaId(Integer temporadaId);

    //List<Temporada> findBySerieId(Integer serieId);
}
