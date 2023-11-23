package com.example.demo.application;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.DTOs.AutorResponse;
import com.example.demo.domain.entities.Autor;
import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.services.AutorService;


@RestController
@RequestMapping("/autor")
@CrossOrigin("*")
public class AutorController {
    
    @Autowired
    private AutorService autorService;

    @Secured({"ADMIN", "USER"})
    @GetMapping
    public ResponseEntity<List<Autor>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.getAllAutors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.getOneAutor(id).get());
    }

    @PostMapping
    public ResponseEntity<String> saveOne(@RequestBody Autor autor){
        autorService.saveAutor(autor);
        return ResponseEntity.status(HttpStatus.OK).body("Autor añadido Correctamente");
    }

    @GetMapping("/comics/{id}")
    public ResponseEntity<Set<Comic>> getAllComics(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.getComics(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AutorResponse> deleteAutor(@PathVariable Long id) {
        return new ResponseEntity<>(autorService.eliminarAutor(id), HttpStatus.OK);
    }


}
