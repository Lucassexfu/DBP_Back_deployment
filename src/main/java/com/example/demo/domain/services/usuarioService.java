package com.example.demo.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Usuario;
import com.example.demo.infraestructure.usuarioRepository;


@Service
public class usuarioService {
    @Autowired
    private usuarioRepository usuarioRepository;

    public Usuario GenerarNuevoUsuario(Usuario user){
        return usuarioRepository.save(user);
    }

    public Optional<Usuario> getMyUser(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario obtenerIdPorNombreUsuario(String nombreUsuario) {
       return usuarioRepository.findByNombre(nombreUsuario);
        
    }
    public List<Long> GetIdComics_created(Long id){
        Usuario RUsuario = usuarioRepository.findById(id).get();
        List<Long> idsComics =new ArrayList<>();
        List<Comic> Cposteados = RUsuario.getComic_posteado();
        for(Comic c: Cposteados){ 
            idsComics.add(c.getId());
        }
        return idsComics;
        
    }

}