package com.eCommerce.demo.repository;

import com.eCommerce.demo.Modelo.DTO.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findComprasById(long id);
}
