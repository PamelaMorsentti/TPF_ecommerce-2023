package com.eCommerce.demo.Modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductosRequestDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private BigDecimal precio;
    private String foto;
    private BigDecimal tamaño;
    private String tipo;

}
