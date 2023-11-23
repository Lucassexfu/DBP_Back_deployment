package com.example.demo.domain.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.DTOs.AutorResponse;
import com.example.demo.domain.entities.Autor;
import com.example.demo.domain.entities.Comic;
import com.example.demo.infraestructure.autorRepository;
import com.example.demo.infraestructure.comicRepository;


@Service
public class AutorService {

    @Autowired
    private autorRepository autorRepository;
    @Autowired
    private comicRepository comicRepository;


    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public List<Autor> getAllAutors(){
        return autorRepository.findAll();
    }

    public Optional<Autor> getOneAutor(Long id){
        return autorRepository.findById(id);
    }

    AutorResponse getAutor(Autor autor){
        AutorResponse response = new AutorResponse();
        Set<Comic> comics_a = autor.getComics();
        Set<String> comics_nombre = new HashSet<>();
        for(Comic c: comics_a){
            comics_nombre.add(c.getNombre());
        }
        response.setComics(comics_nombre);
        response.setEditorial(autor.getEditorial());
        response.setFecha(autor.getFecha());
        response.setNombre(autor.getNombre());
        return response;
    }
    public AutorResponse eliminarAutor(Long id){
        List<Comic> Comics = comicRepository.findAll();
        Autor existingAutor = autorRepository.findById(id).get();
        for(Comic c: Comics){
            if(c.getAutor() == existingAutor)
                c.setAutor(null);
        }
        comicRepository.saveAll(Comics);
        autorRepository.deleteById(id);
        return getAutor(existingAutor);
    }



    //Para la lista de comics por autor:

    public Set<Comic> getComics(Long id){
       Optional<Autor> a1= autorRepository.findById(id);
       if(a1.isPresent()){
        return a1.get().getComics();
       }
       return Collections.emptySet();

    }

    





    
}
