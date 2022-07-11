package com.webstreaming.proyectoweb.controllers;

import com.webstreaming.proyectoweb.models.Imagen;
import com.webstreaming.proyectoweb.models.Series;
import com.webstreaming.proyectoweb.repositories.ImagenRepository;
import com.webstreaming.proyectoweb.repositories.SeriesRepository;
import com.webstreaming.proyectoweb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/series")
public class SeriesController {

    private final SeriesRepository seriesRepository;
    private final ImagenRepository imagenRepository;

    @Autowired
    public SeriesController(SeriesRepository seriesRepository,//String nombre,
                              ImagenRepository imagenRepository) {
        this.seriesRepository = seriesRepository;
        this.imagenRepository = imagenRepository;
    }


    // GET /api/contacto/32
    @GetMapping("/{serieId}")
    public ResponseEntity<Series> getContactoById(@PathVariable Integer serieId){
        Series series = seriesRepository.findBySerieId(serieId);
        if(series == null){
            return ResponseEntity.notFound().build();
        }
        if(series.getImagen() != null){
            series.setImagenId(series.getImagen().getImagenId());
        }
        return ResponseEntity.ok(series);
    }

    @PostMapping()
    public ResponseEntity<Series> insertContacto(@RequestBody Series obj){

        if(obj.getImagenId() > 0 ){
            Imagen img = imagenRepository.findByImagenId(obj.getImagenId());
            obj.setImagen(img);
            img.setEsTemporal(false);
            imagenRepository.save(img);
        }
        obj =seriesRepository.save(obj);
        return ResponseEntity.ok(obj);
    }

    // DELETE /api/contacto/4
    @DeleteMapping("/{serieId}")
    public ResponseEntity<Boolean> eliminarContacto(@PathVariable Integer serieId){
        Series serie = seriesRepository.findBySerieId(serieId);

        if(serie.getImagen() != null){
            serie.getImagen().setEsTemporal(true);
            imagenRepository.save(serie.getImagen());
        }
        seriesRepository.delete(serie);
        return ResponseEntity.ok(true);
    }


    @PutMapping()
    public ResponseEntity<Series> updateContacto(@RequestBody Series obj){
        Series storedSerie = seriesRepository.findBySerieId(obj.getSerieId());

        Imagen oldImage =null;
        if(storedSerie.getImagen() != null){
            oldImage = imagenRepository.findByImagenId(storedSerie.getImagen().getImagenId());
        }

        Imagen newImage = null;
        if(obj.getImagenId() > 0 ){
            newImage = imagenRepository.findByImagenId(obj.getImagenId());
        }

        if(oldImage != null && oldImage.getImagenId() != newImage.getImagenId()){

            oldImage.setEsTemporal(true);
            imagenRepository.save(oldImage);

        }

        if(newImage != null){
            newImage.setEsTemporal(false);
            imagenRepository.save(newImage);

            storedSerie.setImagen(newImage);
        }


        storedSerie =seriesRepository.save(storedSerie);
        return ResponseEntity.ok(storedSerie);
    }

}
