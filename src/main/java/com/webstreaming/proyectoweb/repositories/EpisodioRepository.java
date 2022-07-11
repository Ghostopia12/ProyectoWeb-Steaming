package com.webstreaming.proyectoweb.repositories;

import com.webstreaming.proyectoweb.models.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodioRepository extends JpaRepository<Episodio,Integer> {
    EpisodioRepository findByEpisodioId(Integer episodioId);
}
