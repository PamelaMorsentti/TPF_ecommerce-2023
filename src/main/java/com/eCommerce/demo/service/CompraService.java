package com.eCommerce.demo.service;
import com.eCommerce.demo.Modelo.DTO.entities.Compra;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompraService {
    List<Compra> getAllCompras();
    Compra getCompraById(Long id);
    Compra createCompra(Compra compra);
    Compra updateCompra(Long id, Compra compra);
    void deleteCompra(Long id);
}
