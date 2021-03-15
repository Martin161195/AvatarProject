package com.mramirez.avatarproject.dao;

import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProductoDAOImpl implements IProductoDAO{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public boolean existeProductoByPartNumber(String partNumber) {
        return productoRepository.existsByPartNumber(partNumber);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Iterable<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findProductByPartNumber(String partNumber) {
        return productoRepository.findByPartNumber(partNumber);
    }
}
