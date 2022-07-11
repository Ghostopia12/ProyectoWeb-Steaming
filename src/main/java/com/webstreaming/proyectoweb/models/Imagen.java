package com.webstreaming.proyectoweb.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imagenId;

    private String fileName;
    private String direc;
    private Date fechaSubida;
    private boolean esTemporal;
}
