package com.eCommerce.demo.controller;

import com.eCommerce.demo.Modelo.DTO.ProductosRequestDTO;
import com.eCommerce.demo.Modelo.DTO.ProductosResponseDTO;
import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import com.eCommerce.demo.Modelo.DTO.mapper.ProductoMapper;
import com.eCommerce.demo.service.IProdcuctosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eCommerce/productos")
public class ProductosController {

    @Qualifier("productoServiceImpl")
    @Autowired
    private final IProdcuctosService productoService;
    private final ProductoMapper productoMapper;
    //private final ProductoService productoService;

    @GetMapping("/all")
    /*
    public ResponseEntity<List<Productos>> getAllProductos() {
        List<Productos> productos = productoService.getAllProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
     */
    public ResponseEntity<List<ProductosResponseDTO>> getAllProductos() {
        List<Productos> productos = productoService.getAllProductos();
        List<ProductosResponseDTO> responseDTOs = productoMapper.toResponseDTOs(productos);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/getProducto/{id}")
    public ResponseEntity<ProductosResponseDTO> getProductoById(@PathVariable("id") Long id) {
        Productos producto = productoService.getProductoById(id);
        /*
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        */
        /*
        ProductosResponseDTO responseDTO = convertToResponseDTO(producto);
        return ResponseEntity.ok(responseDTO);
         */
        /*
        ProductosResponseDTO responseDTO = productoMapper.toResponseDTO(producto);
        return ResponseEntity.ok(responseDTO);
         */

        if (producto != null) {
            ProductosResponseDTO responseDTO = productoMapper.toResponseDTO(producto);
            return ResponseEntity.ok(responseDTO);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProducto")
    public ResponseEntity<ProductosResponseDTO> createProducto(@RequestBody ProductosRequestDTO requestDTO) {
        /*Productos createdProducto = productoService.createProducto(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);*/
        /*
        Productos producto = convertToEntity(requestDTO);
        Productos createdProducto = productoService.createProducto(producto);
        ProductosRequestDTO responseDTO = convertToResponseDTO(createdProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);*/

        Productos producto = productoMapper.toEntity(requestDTO);
        Productos createdProducto = productoService.createProducto(producto);
        ProductosResponseDTO responseDTO = productoMapper.toResponseDTO(createdProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }

    @PutMapping("/updateProducto/{id}")
    public ResponseEntity<ProductosResponseDTO> updateProducto(@PathVariable("id") Long id, @RequestBody ProductosRequestDTO requestDTO) {
        /*
        if (updatedProducto != null) {
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        */
        Productos producto = productoMapper.toEntity(requestDTO);
        Productos updatedProducto = productoService.updateProducto(id, producto);
        ProductosResponseDTO responseDTO = productoMapper.toResponseDTO(updatedProducto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/deleteProducto/{id}")
    /*
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") Long id) {
        boolean deleted = productoService.deleteProducto(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     */
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    private ProductosResponseDTO convertToResponseDTO(Productos producto) {
        /*ProductosResponseDTO responseDTO = new ProductosResponseDTO();
        responseDTO.setId(producto.getId());
        responseDTO.setNombre(producto.getNombre());
        responseDTO.setPrecio(producto.getPrecio());
        // Convertir otros atributos si los hay
        return responseDTO;*/
        return new ProductosResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getFoto(),
                producto.getTamaño(),
                producto.getTipo());
    }

    private ProductosRequestDTO convertToRequestDTO(Productos producto) {
        /* ProductosRequestDTO ProductosRequestDTO = new ProductosRequestDTO();
        requestDTO.setNombre(producto.getNombre());
        requestDTO.setPrecio(producto.getPrecio());
        // Convertir otros atributos si los hay
        return requestDTO;*/
        return new ProductosRequestDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getFoto(),
                producto.getTamaño(),
                producto.getTipo());
    }
}


