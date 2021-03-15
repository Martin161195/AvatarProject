package com.mramirez.avatarproject.dao;

import com.mramirez.avatarproject.domain.Producto;

import java.util.Optional;

public interface IProductoDAO {

    boolean existeProductoByPartNumber(String partNumber);
    Producto createProducto(Producto producto);
    Iterable<Producto> findAllProductos();
    Optional<Producto> findProductByPartNumber(String partNumber);

}
