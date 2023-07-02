package com.eCommerce.demo.service.Impl;

import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import com.eCommerce.demo.repository.ProductoRepository;
import com.eCommerce.demo.service.IProdcuctosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProdcuctosService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Productos> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Productos getProductoById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
/*
    @Override
    public Productos createProducto(Productos producto) {
        return null;
    }

    @Override
    public Productos updateProducto(Long id, Productos producto) {
        return null;
    }

 */

    @Override
    public Productos createProducto(Productos producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Productos updateProducto(Long id, Productos producto) {
        Productos existingProducto = getProductoById(id);
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setPrecio(producto.getPrecio());
        // Actualizar otras propiedades si es necesario
        return productoRepository.save(existingProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        Productos producto = getProductoById(id);
        productoRepository.delete(producto);
    }
}
