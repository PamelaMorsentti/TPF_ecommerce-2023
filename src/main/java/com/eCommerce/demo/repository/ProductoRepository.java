package com.eCommerce.demo.repository;

import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
