package com.eCommerce.demo.service;
import com.eCommerce.demo.Modelo.DTO.entities.DetalleCompra;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DetalleCompraService {
    List<DetalleCompra> getAllDetallesCompra();
    DetalleCompra getDetalleCompraById(Long id);
    DetalleCompra createDetalleCompra(DetalleCompra detalleCompra);
    DetalleCompra updateDetalleCompra(Long id, DetalleCompra detalleCompra);
    boolean deleteDetalleCompra(Long id);
}
