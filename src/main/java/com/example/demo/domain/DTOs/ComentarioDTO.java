package com.example.demo.domain.DTOs;

import com.example.demo.domain.entities.Comentarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {
    private Long id;
    private String contenido;
    private Integer likes;
    private Integer dislikes;
    private String name;


    public ComentarioDTO(Comentarios comentario) {
        this.id = comentario.getId();
        this.contenido = comentario.getContenido();
        this.likes = comentario.getLikes();
        this.dislikes = comentario.getDislikes();
        this.name = comentario.getUser().getNombre();
    }
}
