package com.example.demo.domain.DTOs;

import java.util.List;

import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Usuario;

public class NewPostComicDTO {
    private List<Comic> comics;
    private Usuario user;
    NewPostComicDTO(){}

    public List<Comic> getComic(){
        return comics;
    }
    public Usuario getUsuario(){
        return user;
    }
}

