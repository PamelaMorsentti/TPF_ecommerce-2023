package com.eCommerce.demo.service.Impl;
import com.eCommerce.demo.Modelo.DTO.entities.DetalleCompra;
import com.eCommerce.demo.repository.DetalleCompraRepository;
import com.eCommerce.demo.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    private final DetalleCompraRepository detalleCompraRepository;

    @Autowired
    public DetalleCompraServiceImpl(DetalleCompraRepository detalleCompraRepository) {
        this.detalleCompraRepository = detalleCompraRepository;
    }

    @Override
    public List<DetalleCompra> getAllDetallesCompra() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra getDetalleCompraById(Long id) {
        return detalleCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleCompra no encontrado"));
    }
/*
    @Override
    public DetalleCompra createDetalleCompra(DetalleCompra detalleCompra) {
        return null;
    }

 */

    @Override
    public DetalleCompra createDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public DetalleCompra updateDetalleCompra(Long id, DetalleCompra detalleCompra) {
        DetalleCompra existingDetalleCompra = getDetalleCompraById(id);
        existingDetalleCompra.setProducto(detalleCompra.getProducto());
        existingDetalleCompra.setCantidad(detalleCompra.getCantidad());
        existingDetalleCompra.setPrecioUnitario(detalleCompra.getPrecioUnitario());
        return detalleCompraRepository.save(existingDetalleCompra);
    }

    @Override
    public boolean deleteDetalleCompra(Long id) {
        DetalleCompra detalleCompra = getDetalleCompraById(id);
        detalleCompraRepository.deleteById(id);
        return true;
    }
}
