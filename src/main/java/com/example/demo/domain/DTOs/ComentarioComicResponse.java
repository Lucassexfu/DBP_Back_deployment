package com.example.demo.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioComicResponse {
    private Long id;
    private String contenido;
    private Integer likes;
    private Integer dislikes; 
    private String name_user;
}
