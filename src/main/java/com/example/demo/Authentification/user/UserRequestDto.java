package com.example.demo.Authentification.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Este es nuestro sign up request, add isAdmin

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String nombre;
    private String email;
    private String dni;
    private String contrasenia;
    private int puntos;
    private String isAdmin;
}

