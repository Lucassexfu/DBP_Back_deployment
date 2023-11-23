package com.example.demo.domain.DTOs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllComicsResponse {
    private Long id;

    private String estado;
    private String nombre;
    private String fecha_de_publicación;
    private String descripcion;
    private List<String> imagenes_description;
    private Integer precio;
    private Integer likes;
    private Integer dislikes;
    private Set<String> generos = new HashSet<>();

    private Long id_autor;

    private String id_user;

    private Set<ComentarioComicResponse> comentarios = new HashSet<>();
    private List<TemporadaDTO> temporadas;  
}
