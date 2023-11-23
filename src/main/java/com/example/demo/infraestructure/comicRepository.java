package com.example.demo.infraestructure;
import com.example.demo.domain.entities.Comic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface comicRepository extends JpaRepository<Comic, Long> {
    Optional<Comic> findByNombre(String nombre);
}

