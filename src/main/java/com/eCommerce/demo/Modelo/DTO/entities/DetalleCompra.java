package com.eCommerce.demo.Modelo.DTO.entities;

import jakarta.persistence.*;
/*import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

 */
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Detalle_Compra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_compra_id")
    private Long id;
    @NotNull
    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Transient
    private BigDecimal subtotal;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos producto;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;


    // Método para calcular el subtotal
    public void calcularSubtotal() {
        subtotal = precioUnitario.multiply(new BigDecimal(String.valueOf(cantidad)));
    }

}
