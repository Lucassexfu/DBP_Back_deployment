package com.example.demo.domain.DTOs;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorResponse {
    private String nombre;
    private String editorial;
    private String fecha;
    private Set<String> comics;
}    
