package com.eCommerce.demo.repository;

import com.eCommerce.demo.Modelo.DTO.entities.DetalleCompra;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long>{
}
