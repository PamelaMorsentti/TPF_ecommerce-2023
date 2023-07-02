package com.eCommerce.demo.Modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosResponseDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private BigDecimal precio;
    private String foto;
    private BigDecimal tamaño;
    private String tipo;

}
