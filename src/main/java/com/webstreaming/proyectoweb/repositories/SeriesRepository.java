package com.webstreaming.proyectoweb.repositories;

import com.webstreaming.proyectoweb.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series,Integer> {
    Series findBySerieId(Integer seriesId);
}
