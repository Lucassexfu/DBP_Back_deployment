package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.DTOs.NewComentarioDTO;
import com.example.demo.domain.DTOs.NewPostComicDTO;
import com.example.demo.domain.entities.Comentarios;
import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Usuario;

import com.example.demo.domain.services.comentarioService;
import com.example.demo.domain.services.comicService;
import com.example.demo.domain.services.usuarioService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class usuarioController {
    @Autowired
    private comicService comicService;

    @Autowired
    private comentarioService comentarioService;

    @Secured({"ADMIN", "USER"})
    @PostMapping("/registrar_comentario")
    public ResponseEntity<String> HacerComentario(@RequestBody NewComentarioDTO coment){
        Comentarios Ncomentario = comentarioService.GenerarComentario(coment.getContent());
        comicService.RegistrarComentario(coment.getUsuario().getId(), Ncomentario.getId());
        return new ResponseEntity<>("Nuevo comentario !", HttpStatus.CREATED);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/postear_comics")
    public ResponseEntity<List<Comic>> PostearComic(@RequestBody NewPostComicDTO NewComic){
        return new ResponseEntity<>(comicService.GuardarPostComic(NewComic.getComic(), NewComic.getUsuario()), HttpStatus.CREATED);
    }

    //Post --------------[Usuario]---------------------- 
    @Autowired
    private usuarioService usuarioService;
    @Secured({"ADMIN", "USER"})
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody Usuario user){
        usuarioService.GenerarNuevoUsuario(user);
        return ResponseEntity.ok().body("Ty usuario creado a aprtir del signup [magia]");
    }

    // @Secured({"ADMIN", "USER"})
    // @GetMapping
    // public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
    //     return ResponseEntity.ok().body(usuarioService.getMyUser(id).get());
    // }

    // id por nombre de usuario: 
    @Secured({"ADMIN", "USER"})
    @GetMapping("/id/{name}")
    public ResponseEntity<Usuario> HacerComentario23(@PathVariable String name){
    return ResponseEntity.ok().body(usuarioService.obtenerIdPorNombreUsuario(name));

    }





    


}

