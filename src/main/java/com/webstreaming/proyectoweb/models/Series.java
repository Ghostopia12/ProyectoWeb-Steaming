package com.webstreaming.proyectoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serieId;

    private String descripcion;
    @Size(max = 100)
    private String nombreSerie;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "imagenId", nullable = true)
    private Imagen imagen;

    @JsonInclude
    @Transient
    private int imagenId;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Temporada> temporadas;

    public Series(){
        temporadas = new ArrayList<>();
    }

    public void  setImagen(Imagen img){
        this.imagen = img;
        if(img != null) {
            this.imagenId = img.getImagenId();
        }else {
            this.imagenId = 0;
        }
    }
}
