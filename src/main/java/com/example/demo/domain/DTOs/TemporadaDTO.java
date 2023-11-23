package com.example.demo.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemporadaDTO {
    private Long id;
    private String temporada_nombre;
    private String temporada_descripcion;
    private String temporada_url;
}
