package com.mramirez.avatarproject.service;


import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.exception.ProductoException;
import com.mramirez.avatarproject.util.ProductoValidators;

import com.mramirez.avatarproject.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public Producto getProductoByPartNumber(String partNumber) throws ProductoException {

        Optional<Producto> productoOptional = productoRepository.findByPartNumber(partNumber);

        if(productoOptional.isPresent()){

            return productoOptional.get();
        }else{

            throw new ProductoException(HttpStatus.NOT_FOUND);
        }

    }

    public Map<String, List<Producto>> getAllProductos() throws ProductoException {

        List<Producto> productoList = new ArrayList<>();

        Map<String, List<Producto>> productoMap = new HashMap<>();

        productoMap.put("productos", productoList);
        productoRepository.findAll().iterator().forEachRemaining(productoList::add);

        if(productoList.isEmpty()){

            throw new ProductoException(HttpStatus.NOT_FOUND);
        }else{

            return productoMap;

        }



    }


    public void saveProducto(Producto producto) throws ProductoException {

       if(isProductByPartNumberExist(producto.getPartNumber())){

            throw  new ProductoException("El Partnumber "+producto.getPartNumber()+" ya está registrado", HttpStatus.INTERNAL_SERVER_ERROR);

       }else{

           if(ProductoValidators.isValidTipoProduct(producto)){

               productoRepository.save(producto);
           }


       }
    }

    public boolean isProductByPartNumberExist(String partNumber){

        return productoRepository.existsByPartNumber(partNumber);

    }
}
