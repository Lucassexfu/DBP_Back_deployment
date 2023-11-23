package com.example.demo.domain.DTOs;

import com.example.demo.domain.entities.Comic;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ComicDto {
    private Long id;
    private String estado;
    private String nombre;
    private String fecha_de_publicacion;
    private Integer precio;
    private Integer likes;
    private Integer dislikes;
    private String autorNombre;  // Agrega este campo para el nombre del autor

    // Constructor que toma un objeto Comic y realiza el mapeo
    public ComicDto(Comic comic) {
        this.id = comic.getId();
        this.estado = comic.getEstado();
        this.nombre = comic.getNombre();
        this.fecha_de_publicacion = comic.getFecha_de_publicación();
        this.precio = comic.getPrecio();
        this.likes = comic.getLikes();
        this.dislikes = comic.getDislikes();

        // Obtén el nombre del autor
        if (comic.getAutor() != null) {
            this.autorNombre = comic.getAutor().getNombre();
        }
    }

    // Getters y setters
}
