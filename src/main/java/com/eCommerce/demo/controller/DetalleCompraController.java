package com.eCommerce.demo.controller;

import com.eCommerce.demo.Modelo.DTO.entities.DetalleCompra;
import com.eCommerce.demo.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-compra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public ResponseEntity<List<DetalleCompra>> getAllDetallesCompra() {
        List<DetalleCompra> detallesCompra = detalleCompraService.getAllDetallesCompra();
        return new ResponseEntity<>(detallesCompra, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCompra> getDetalleCompraById(@PathVariable("id") Long id) {
        DetalleCompra detalleCompra = detalleCompraService.getDetalleCompraById(id);
        if (detalleCompra != null) {
            return new ResponseEntity<>(detalleCompra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleCompra> createDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        DetalleCompra createdDetalleCompra = detalleCompraService.createDetalleCompra(detalleCompra);
        return new ResponseEntity<>(createdDetalleCompra, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCompra> updateDetalleCompra(@PathVariable("id") Long id, @RequestBody DetalleCompra detalleCompra) {
        DetalleCompra updatedDetalleCompra = detalleCompraService.updateDetalleCompra(id, detalleCompra);
        if (updatedDetalleCompra != null) {
            return new ResponseEntity<>(updatedDetalleCompra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDetalleCompra(@PathVariable("id") Long id) {
        boolean deleted = detalleCompraService.deleteDetalleCompra(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
