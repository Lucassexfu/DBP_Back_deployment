package com.example.demo.domain.services;
import java.util.stream.Collectors;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.DTOs.ComentarioDTO;
import com.example.demo.domain.entities.Comentarios;
import com.example.demo.infraestructure.comentariosRepository;

@Service
public class comentarioService {

    @Autowired
    private comentariosRepository comentariosRepository;

    public Comentarios GenerarComentario(String content){
        Comentarios Ncoment = new Comentarios();
        Ncoment.setContenido(content);
        Ncoment.setLikes(0);
        Ncoment.setDislikes(0);
        return comentariosRepository.save(Ncoment);
    }

    //Metodos: 

    //POST
    // Vamos a ver si dandole el user y el comic el comentario se crea adecudamente
    public Comentarios saveComentario(Comentarios comentarios){

        return comentariosRepository.save(comentarios);
    }

    //GET
    public List<Comentarios> getComentario(){
        return comentariosRepository.findAll();
    }

    //Get de comentarios por id
    // public List<Comentarios> getComentariosPorComic(Long id_comic){
    //     return comentariosRepository.findAllByComicId(id_comic);
    // }

    public List<ComentarioDTO> getComentariosPorComic(Long idComic) {
        List<Comentarios> comentarios = comentariosRepository.findAllByComicId(idComic);
        return comentarios.stream().map(ComentarioDTO::new).collect(Collectors.toList());
    }

    public String dar_like(Long id){
        Optional<Comentarios> c =  comentariosRepository.findById(id);
        c.get().setLikes(c.get().getLikes()+1);
        comentariosRepository.save(c.get());
        return "Liked";
    }

    public String dar_dislike(Long id){
        Optional<Comentarios> c =  comentariosRepository.findById(id);
        c.get().setDislikes(c.get().getDislikes()+1);
        comentariosRepository.save(c.get());

        return "disLiked";
    }

    public String eliminarComentario(Long id){
        Optional<Comentarios> comentarioOptional = comentariosRepository.findById(id);
        if (comentarioOptional.isPresent()) {
            comentariosRepository.deleteById(id);
            return "Comentario eliminado exitosamente";
        } else {
            return "Comentario no encontrado";
        }

    }




}
