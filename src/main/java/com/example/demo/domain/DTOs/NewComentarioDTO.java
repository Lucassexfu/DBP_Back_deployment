package com.example.demo.domain.DTOs;

import com.example.demo.domain.entities.Usuario;

public class NewComentarioDTO {
    private Usuario user;
    private String content;

    NewComentarioDTO(){}

    public void setUsuario(Usuario user){
        this.user = user;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Usuario getUsuario(){
        return user;
    }

    public String getContent(){
        return content;
    }

}
