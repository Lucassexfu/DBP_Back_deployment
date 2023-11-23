package com.example.demo.application;
import java.util.*;
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

import com.example.demo.domain.DTOs.ComentarioDTO;
import com.example.demo.domain.entities.Comentarios;
import com.example.demo.domain.services.comentarioService;
import com.example.demo.domain.services.comicService;

@RestController
@CrossOrigin
@RequestMapping("/comentario")
public class comentarioController {
    @Autowired
    private comicService comicService;

    @Autowired
    private comentarioService comentarioService;

    //eSTE ES LIKE COMICS SJKDJSK
    @Secured({"ADMIN", "USER"})
    @PostMapping("/like_comic/{comentarioId}")
    public ResponseEntity<String> DarLikeComentario(@PathVariable Long comentarioId){
        comicService.ActualizarLikesComentario(comentarioId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/dislike_comic/{comentarioId}")
    public ResponseEntity<String> DarDisLikeComentario(@PathVariable Long comentarioId){
        comicService.ActualizarDisLikesComentario(comentarioId);
        return new ResponseEntity<>( "dislike", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/like_comic")
    public ResponseEntity<String> DarLikeComic(@PathVariable Long comicId){
        comicService.ActializarLikesComic(comicId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/dislike_comic")
    public ResponseEntity<String> DarDisLikeComic(@PathVariable Long comicId){
        comicService.ActializarDisLikesComic(comicId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @GetMapping("/get")
    public ResponseEntity<String> da(){
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }
    //Metodo post
    @Secured({"ADMIN", "USER"})
    @PostMapping
    public ResponseEntity<String> postComentario(@RequestBody Comentarios comentario){
        comentarioService.saveComentario(comentario);
        return new ResponseEntity<>( "Comentario subido correctamente!", HttpStatus.OK);
    }

    // @Secured({"ADMIN", "USER"})
    // @PostMapping
    // public ResponseEntity<String> enrrollComentarioComic(@RequestBody Comentarios comentario){
    //     comentarioService.saveComentario(comentario);
    //     return new ResponseEntity<>( "Comentario subido correctamente!", HttpStatus.OK);
    // }

    //Metodo get
    @Secured({"ADMIN", "USER"})
    @GetMapping
    public ResponseEntity<List<Comentarios>> getComentario(){
        return ResponseEntity.status(200).body(comentarioService.getComentario());
    }

    //Metodo get de comentarios por id de comic
    // @Secured({"ADMIN", "USER"})
    // @GetMapping("/{id_comic}")
    // public ResponseEntity<List<Comentarios>> get_comentairo_para_comic(@PathVariable Long id_comic){
    //     return ResponseEntity.status(200).body(comentarioService.getComentariosPorComic(id_comic));
    // }

    @GetMapping("/{idComic}")
    public ResponseEntity<List<ComentarioDTO>> getComentariosPorComic(@PathVariable Long idComic) {
        List<ComentarioDTO> comentariosDTO = comentarioService.getComentariosPorComic(idComic);
        return ResponseEntity.ok(comentariosDTO);
    }

    //Like comentario
    @Secured({"ADMIN", "USER"})
    @PostMapping("/like_comentario/{comentarioId}")
    public ResponseEntity<String> Like_comentario(@PathVariable Long comentarioId){
        comentarioService.dar_like(comentarioId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/dislike_comentario/{comentarioId}")
    public ResponseEntity<String> disLike_comentario(@PathVariable Long comentarioId){
        comentarioService.dar_dislike(comentarioId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    //Desvivir a un comentario chiquito sjkdsj: 
    @Secured({"ADMIN", "USER"})
    @PostMapping("/delete/{comentarioId}")
    public ResponseEntity<String> eliminarCOMENTARIO(@PathVariable Long comentarioId){
        comentarioService.eliminarComentario(comentarioId);
        return new ResponseEntity<>( "Comentario eliminado", HttpStatus.OK);
    }


}
