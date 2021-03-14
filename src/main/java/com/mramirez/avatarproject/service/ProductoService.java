package com.mramirez.avatarproject.service;


import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.util.ProductoValidators;

import com.mramirez.avatarproject.exception.ProductoExceptionHandler;
import com.mramirez.avatarproject.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public Producto getProductoByPartNumber(String partNumber){

        return productoRepository.findByPartNumber(partNumber).orElse(null);

    }

    public List<Producto> getAllProductos(){

        List<Producto> productoList = new ArrayList<>();

        productoRepository.findAll().iterator().forEachRemaining(productoList::add);

        return productoList;

    }


    public void saveProducto(Producto producto) throws ProductoExceptionHandler {

       if(isProductByPartNumberExist(producto.getPartNumber())){

       }else{

           if(ProductoValidators.isValidProducto(producto)){

               productoRepository.save(producto);
           }

       }



    }

    public boolean isProductByPartNumberExist(String partNumber){

        return productoRepository.existsByPartNumber(partNumber);

    }
}
