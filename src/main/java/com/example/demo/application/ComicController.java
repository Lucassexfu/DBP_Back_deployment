package com.example.demo.application;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.DTOs.AllComicsResponse;
import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.services.comicService;


@RestController
@RequestMapping("/comics")
@CrossOrigin("*")
public class ComicController {
    
    @Autowired
    private comicService comicService;

    @Secured({"ADMIN", "USER"})
    @GetMapping
    public ResponseEntity<List<AllComicsResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(comicService.getComics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comic> getOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(comicService.getComicicito(id).get());
    }

    

}
