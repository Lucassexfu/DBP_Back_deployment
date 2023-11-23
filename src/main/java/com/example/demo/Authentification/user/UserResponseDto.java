package com.example.demo.Authentification.user;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String nombre;
    private String email;
    private String dni;
    private String contrasenia;
    private int puntos;
    private List<String> comic_posteados_nombres;
    private Set<String> comentarios;
}

