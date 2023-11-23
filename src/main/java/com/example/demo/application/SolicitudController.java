package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.DTOs.ModificarSolicitudDTO;
import com.example.demo.domain.DTOs.RequestSolicitudDTO;
import com.example.demo.domain.services.SolicitudService;

@RestController
@CrossOrigin("*")
@RequestMapping("/Solicitud")
public class SolicitudController {
    @Autowired
    private SolicitudService SolicitudService;

    @Secured({"ADMIN", "USER"})
    @PostMapping
    public ResponseEntity<String> GenerarSolicitud(@RequestBody RequestSolicitudDTO solicitud){
        return new ResponseEntity<>(SolicitudService.guardarSolicitud(solicitud), HttpStatus.CREATED);
    }
    @Secured({"ADMIN"})
    @GetMapping("/ver_Solicitud")
    public ResponseEntity<List<RequestSolicitudDTO>> VerSolicitud(){
        return new ResponseEntity<>(SolicitudService.VerSolicitudes(), HttpStatus.OK);
    }
    @Secured({"ADMIN"})
    @GetMapping("/ver_Solicitud/{id}")
    public ResponseEntity<RequestSolicitudDTO> VerSolicitudById(@PathVariable Long id ){
        return new ResponseEntity<>(SolicitudService.VerSolicitudesIdUser(id), HttpStatus.OK);
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/ver_Solicitud/{id}")
    public ResponseEntity<RequestSolicitudDTO> Eliminar(@PathVariable Long id ){
        return new ResponseEntity<>(SolicitudService.EliminarSolicitud(id), HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PatchMapping("/modificar_solicitud/{nombre}")
    public ResponseEntity<String> ModificarDatos(@RequestBody ModificarSolicitudDTO solicitud_cambio, @PathVariable String Nombre){
        return new ResponseEntity<>(SolicitudService.Modificar(solicitud_cambio, Nombre), HttpStatus.OK);
    }

}