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
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int temporadaId;
    @Size(max = 100)
    private String nombreTemporada;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "serieId", nullable = false)
    private Series series;

    @JsonInclude
    @Transient
    private int serieId;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episodio> episodios;

    public Temporada(){
        episodios = new ArrayList<>();
    }

    public void setSeries(Series seri){
        this.series = seri;
        if(seri != null) {
            this.serieId = seri.getSerieId();
        }else {
            this.serieId = 0;
        }
    }
}
