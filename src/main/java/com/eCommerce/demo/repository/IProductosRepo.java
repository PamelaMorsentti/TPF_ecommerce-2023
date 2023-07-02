package com.eCommerce.demo.repository;

import com.eCommerce.demo.Modelo.DTO.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface IProductosRepo extends JpaRepository<Productos, String> {
    boolean existsByNombre(String nombre);
}
