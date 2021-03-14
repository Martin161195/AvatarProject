package com.mramirez.avatarproject.util;

import com.mramirez.avatarproject.domain.Producto;

public class ProductoValidators {


    public static boolean isValidProducto(Producto producto){

        if(producto.getTipoProducto().toLowerCase().equalsIgnoreCase("normal") && producto.getCantidadComponentes()==0){
            return true;
        }else{
            return producto.getTipoProducto().toLowerCase().equalsIgnoreCase("paquete") && producto.getCantidadComponentes() >= 1;
        }
    }



}
