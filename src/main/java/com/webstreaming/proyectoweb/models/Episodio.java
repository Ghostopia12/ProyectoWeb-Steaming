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
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int episodioId;

    @Size(max = 100)
    private String titulo;

    private String descripcion;
    private String youtubeVideoId;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "temporadaId", nullable = false)
    private Temporada temporada;

    @JsonInclude
    @Transient
    private int temporadaId;


    public void  setTemporada(Temporada tempo){
        this.temporada = tempo;
        if(tempo != null) {
            this.temporadaId = tempo.getTemporadaId();
        }else {
            this.temporadaId = 0;
        }
    }
}
