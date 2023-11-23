package com.example.demo.infraestructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Solicitud;
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    Optional<Solicitud> findById(Long id);
}
    