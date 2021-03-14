package com.mramirez.avatarproject.util;

import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.exception.ProductoException;
import org.springframework.http.HttpStatus;


//replaceAll("\\s", "")
public class ProductoValidators {

    public static boolean isValidTipoProduct(Producto producto) throws ProductoException {

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
