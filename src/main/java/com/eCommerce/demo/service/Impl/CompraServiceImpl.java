package com.eCommerce.demo.service.Impl;

import com.eCommerce.demo.Modelo.DTO.entities.Compra;
import com.eCommerce.demo.repository.CompraRepository;
import com.eCommerce.demo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;

    @Autowired
    public CompraServiceImpl(CompraRepository CompraRepository) {
        this.compraRepository = CompraRepository;
    }

    @Override
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra getCompraById(Long id) {
        return compraRepository.findById(Long.valueOf(id.toString()))
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
    }

    @Override
    public Compra createCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra updateCompra(Long id, Compra compra) {
        Compra existingCompra = getCompraById(id);
        existingCompra.setFecha(compra.getFecha());
        // Actualizar otras propiedades si es necesario
        return compraRepository.save(existingCompra);
    }

    @Override
    public void deleteCompra(Long id) {
        Compra compra = getCompraById(id);
        compraRepository.delete(compra);
    }
}
