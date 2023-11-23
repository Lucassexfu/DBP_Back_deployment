package com.example.demo.infraestructure;
import com.example.demo.domain.entities.Venta;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ventaRepository extends JpaRepository<Venta, Long> {}

