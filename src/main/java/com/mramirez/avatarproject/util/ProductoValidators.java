package com.mramirez.avatarproject.util;

import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.exception.ProductoException;
import org.springframework.http.HttpStatus;



public class ProductoValidators {



    public static boolean isValidProduct(Producto producto) throws ProductoException {
        if(     !(isValidProductByPartNumber(producto.getPartNumber()) ) ||
                (producto.getNombre()== null || producto.getNombre().isEmpty()  )  ||
                (producto.getImagen()== null  || producto.getImagen().isEmpty() )  ||
                !(isValidProductByTipoProduct(producto))
        ){
            throw new ProductoException(HttpStatus.BAD_REQUEST);
        }

        return  true;
    }

    public static boolean isValidProductByPartNumber(String s) throws ProductoException {

        if(s == null || s.length() != 10){
            throw new ProductoException("El Partnumber "+s+" debe tener 10 digitos", HttpStatus.BAD_REQUEST);
        }

        return true;

    }


    public static boolean isValidProductByTipoProduct(Producto producto) throws ProductoException {

        switch (producto.getTipoProducto().toLowerCase()){
            case "normal" :
                if(producto.getCantidadComponentes()!= 0){
                    throw new ProductoException("El Partnumber "+producto.getPartNumber()+
                            " es tipo "+ producto.getTipoProducto()+
                            " la cantidad de componentes no puede ser mayor a 0", HttpStatus.BAD_REQUEST);
                }else{
                    return true;
                }
            case "paquete" :
                if(producto.getCantidadComponentes() == 0){
                    throw new ProductoException("El Partnumber "+producto.getPartNumber()+
                            " es tipo "+ producto.getTipoProducto()+
                            " la cantidad de componentes no puede ser  0", HttpStatus.BAD_REQUEST);
                }else{
                    return true;
                }

            default:
                throw new ProductoException("El Partnumber "+producto.getPartNumber()+
                        " tiene un tipo de producto :  "+ producto.getTipoProducto()+
                        " que no es válido. Por favor ingrese un tipo válido", HttpStatus.BAD_REQUEST);

        }

    }




}
