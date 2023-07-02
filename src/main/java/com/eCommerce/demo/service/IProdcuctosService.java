package com.eCommerce.demo.service;

import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProdcuctosService {
    List<Productos> getAllProductos();
    Productos getProductoById(Long id);
    Productos createProducto(Productos producto);
    Productos updateProducto(Long id, Productos producto);

    void deleteProducto(Long id);
}

