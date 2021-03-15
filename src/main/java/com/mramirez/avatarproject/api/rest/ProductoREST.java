package com.mramirez.avatarproject.api.rest;


import com.mramirez.avatarproject.domain.Producto;
import com.mramirez.avatarproject.exception.ProductoException;
import com.mramirez.avatarproject.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ProductoREST {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/producto")
    public ResponseEntity<Map<String, List<Producto>>> getAllProducts() throws ProductoException {

        return new ResponseEntity<>(productoService.getAllProductos(), HttpStatus.OK);

    }

    @GetMapping(value= "/producto/{partNumber}")
    public ResponseEntity<Producto> getProductoByPartNumber(@PathVariable("partNumber") String partNumber) throws ProductoException {

        return new ResponseEntity<>(productoService.getProductoByPartNumber(partNumber), HttpStatus.OK);

    }

    @PostMapping(value = "/producto")
    public void saveProducto(@RequestBody Producto producto  ) throws  ProductoException {
            productoService.saveProducto(producto);
    }
}
