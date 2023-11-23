package com.example.demo.domain.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambiarSolicitudDTO {
    private String Descripcion;
    private String Ocupacion;
    private String fecha;
    private List<Long> comics_ids;
    private String nombre_usuario;
}
