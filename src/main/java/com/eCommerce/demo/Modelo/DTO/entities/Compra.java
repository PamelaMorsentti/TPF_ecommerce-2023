package com.eCommerce.demo.Modelo.DTO.entities;
import com.eCommerce.demo.Modelo.DTO.entities.Productos;

//import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.*;
/*import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Compra")

/* esta entidad tomaria la los productos seleccionados y debería generar el total, el valor de la compra */
public class Compra {
    @Id
    //public Long getId(){return id;}
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id", nullable = false, length = 11)
    private Long id ; // este id de compra deberia estar relacionado con los id_productos
    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "compra_id")
    private Set<Productos> productos = new HashSet<Productos>();
*/
    @ManyToMany
    @JoinTable(
            name = "detalle_compra",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Productos> productos;
    @NotNull
    @NotBlank
    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;
    @NotNull
    @NotBlank
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    @NotNull
    @NotBlank
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @NotNull
    @NotBlank
    @Column(name = "fecha")
    private Date fecha;

}
