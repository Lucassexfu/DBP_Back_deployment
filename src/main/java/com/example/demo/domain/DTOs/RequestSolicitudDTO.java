package com.example.demo.domain.DTOs;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestSolicitudDTO {
    private String Descripcion;
    private String Ocupacion;
    private String fecha;
    private Long usuarioId;
    private List<String> comics;  
}

