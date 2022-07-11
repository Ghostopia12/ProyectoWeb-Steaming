package com.webstreaming.proyectoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listaId;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @JsonInclude
    @Transient
    private int usuarioId;


    public void  setUsuario(Usuario user){
        this.usuario = user;
        if(user != null) {
            this.usuarioId = user.getUsuarioId();
        }else {
            this.usuarioId = 0;
        }
    }


    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "serieId", nullable = false)
    private Series series;

    @JsonInclude
    @Transient
    private int serieId;


    public void  setSerie(Series seri){
        this.series = seri;
        if(seri != null) {
            this.serieId = seri.getSerieId();
        }else {
            this.serieId = 0;
        }
    }
}
