package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Venta;
import com.example.demo.domain.services.comicService;
import com.example.demo.domain.services.ventaService;

@RestController
@CrossOrigin
@RequestMapping("/venta")
public class ventaController {
    @Autowired
    private ventaService ventaService;
    @Autowired
    private comicService comicService;

    @Secured({"ADMIN", "USER"})
    @PostMapping("/registrar_compra")
    public ResponseEntity<String> createVenta(@RequestBody List<Comic> comics){
        Venta new_venta = comicService.GenerarCompra(comics);
        Venta venta_saved = ventaService.RegistrarVenta(new_venta);
        if(venta_saved == null){
            return new ResponseEntity<>("Error creating", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Tu compra ha sido realizada", HttpStatus.CREATED);
        }   
    }
}
