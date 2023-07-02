package com.eCommerce.demo.controller;

import com.eCommerce.demo.Modelo.DTO.entities.Compra;
import com.eCommerce.demo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> getAllCompras() {
        List<Compra> compras = compraService.getAllCompras();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable("id") Long id) {
        Compra compra = compraService.getCompraById(id);
        if (compra != null) {
            return new ResponseEntity<>(compra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
        Compra createdCompra = compraService.createCompra(compra);
        return new ResponseEntity<>(createdCompra, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable("id") Long id, @RequestBody Compra compra) {
        Compra updatedCompra = compraService.updateCompra(id, compra);
        if (updatedCompra != null) {
            return new ResponseEntity<>(updatedCompra, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCompra(@PathVariable("id") Long id) {
        compraService.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*
    public ResponseEntity<HttpStatus> deleteCompra(@PathVariable("id") Long id) {
        boolean deleted = compraService.deleteCompra(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     */
}
