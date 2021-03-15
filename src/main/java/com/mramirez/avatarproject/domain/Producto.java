package com.mramirez.avatarproject.domain;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String partNumber;

    private String tipoProducto;


    private String nombre;


    private String imagen;


    private int cantidadComponentes;

}
