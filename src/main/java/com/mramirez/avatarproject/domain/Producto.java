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

    @Column
    private String partNumber;

    @Column
    private String tipoProducto;

    @Column
    private String nombre;

    @Column
    private String imagen;

    @Column
    private int cantidadComponentes;



}
