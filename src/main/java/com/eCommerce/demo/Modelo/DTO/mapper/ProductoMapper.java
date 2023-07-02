package com.eCommerce.demo.Modelo.DTO.mapper;

import com.eCommerce.demo.Modelo.DTO.ProductosRequestDTO;
import com.eCommerce.demo.Modelo.DTO.ProductosResponseDTO;
import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoMapper {
    public ProductosResponseDTO toResponseDTO(Productos producto) {
        return new ProductosResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getFoto(),
                producto.getTamaño(),
                producto.getTipo()
        );
    }

    public List<ProductosResponseDTO> toResponseDTOs(List<Productos> productos) {
        List<ProductosResponseDTO> responseDTOs = new ArrayList<>();
        for (Productos producto : productos) {
            ProductosResponseDTO responseDTO = new ProductosResponseDTO();
            // Mapear propiedades del producto a responseDTO
            responseDTO.setId(producto.getId());
            responseDTO.setNombre(producto.getNombre());
            responseDTO.setCategoria(producto.getCategoria());
            responseDTO.setDescripcion(producto.getDescripcion());
            responseDTO.setPrecio(producto.getPrecio());
            responseDTO.setFoto(producto.getFoto());
            responseDTO.setTamaño(producto.getTamaño());
            responseDTO.setTipo(producto.getTipo());
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }

    public ProductosRequestDTO toRequestDTO(ProductosRequestDTO requestDTO) {
        return new ProductosRequestDTO(
                requestDTO.getId(),
                requestDTO.getNombre(),
                requestDTO.getCategoria(),
                requestDTO.getDescripcion(),
                requestDTO.getPrecio(),
                requestDTO.getFoto(),
                requestDTO.getTamaño(),
                requestDTO.getTipo()
        );
    }

    /*
    public ProductosResponseDTO (Productos producto) {
        ProductosResponseDTO responseDTO = new ProductosResponseDTO();
        responseDTO.setId(producto.getId());
        responseDTO.setNombre(producto.getNombre());
        responseDTO.setPrecio(producto.getPrecio());
        // Convertir otros atributos si los hay
        return responseDTO;
    }

    public ProductosRequestDTO toRequestDTO(Productos producto) {
        ProductosRequestDTO requestDTO = new ProductosRequestDTO();
        requestDTO.setNombre(producto.getNombre());
        requestDTO.setPrecio(producto.getPrecio());
        // Convertir otros atributos si los hay
        return requestDTO;
    }

     */

    public Productos toEntity(ProductosRequestDTO requestDTO) {
        Productos producto = new Productos();
        producto.setNombre(requestDTO.getNombre());
        producto.setCategoria(requestDTO.getCategoria());
        producto.setDescripcion(requestDTO.getDescripcion());
        producto.setPrecio(requestDTO.getPrecio());
        producto.setFoto(requestDTO.getFoto());
        producto.setTamaño(requestDTO.getTamaño());
        producto.setTipo(requestDTO.getTipo());
        return producto;
    }
}

