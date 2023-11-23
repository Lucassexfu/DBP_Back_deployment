package com.example.demo.infraestructure;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Comentarios;



public interface comentariosRepository extends JpaRepository<Comentarios, Long> {
    List<Comentarios> findAllByComicId(Long idComic);
}

