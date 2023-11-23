package com.example.demo.infraestructure;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Autor;

public interface autorRepository extends JpaRepository<Autor, Long> {
    void deleteById(Long id);
}


