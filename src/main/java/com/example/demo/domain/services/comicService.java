package com.example.demo.domain.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.DTOs.AllComicsResponse;
import com.example.demo.domain.DTOs.ComentarioComicResponse;
import com.example.demo.domain.DTOs.ComicDto;
import com.example.demo.domain.DTOs.TemporadaDTO;
import com.example.demo.domain.entities.Autor;
import com.example.demo.domain.entities.Comentarios;
import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Temporada;
import com.example.demo.domain.entities.Usuario;
import com.example.demo.domain.entities.Venta;
import com.example.demo.infraestructure.autorRepository;
import com.example.demo.infraestructure.comentariosRepository;
import com.example.demo.infraestructure.comicRepository;
import com.example.demo.infraestructure.usuarioRepository;
import com.example.demo.infraestructure.ventaRepository;

@Service
public class comicService {
    @Autowired
    private comicRepository comicRepository;
    @Autowired
    private ventaRepository ventaRepository;
    @Autowired
    private comentariosRepository comentariosRepository;
    @Autowired
    private usuarioRepository usuarioRepository;
    @Autowired
    private autorRepository autorRepository;

    public Comic GuardarComic(Comic comic){
        Autor CAutor = comic.getAutor();
        Autor SAutor = autorRepository.save(CAutor);
        Comic SComic = comicRepository.save(comic);
        SComic.setAutor(SAutor);
        Set<Comic> AComics = SAutor.getComics();
        AComics.add(SComic);
        SAutor.setComics(AComics);
        autorRepository.save(SAutor);
        return comicRepository.save(SComic);
    }
    public List<Comic> GuardarPostComic(List<Comic> comics, Usuario user){
        List<Comic> NComics = new ArrayList<>();
        for(Comic crearComic: comics){
            NComics.add(comicRepository.save(crearComic));
        }
        Usuario AUser = usuarioRepository.findById(user.getId()).get();
        AUser.setComic_posteado(NComics);
        Usuario Nuser = usuarioRepository.save(AUser);
        for(Comic OComic: comics){
            OComic.setUser(Nuser);
            comicRepository.save(OComic);
        }

        return NComics;
    }
    public Venta GenerarCompra(List <Comic> comics){
        Venta Rventa = new Venta();
        Set<Comic> tempc = new HashSet<>(comics);
        Rventa.setComics(tempc);
        Rventa.setEstado("0");
        Integer Ptotal = 0;
        for(Comic Vcomic: comics){
            Ptotal += Vcomic.getPrecio();
        }
        Rventa.setPrecio_total(Ptotal);
        Rventa.setCosto_de_envio(0.1 * Ptotal);
        return ventaRepository.save(Rventa);
    }

    public void RegistrarComentario(Long comicId, Long comentarioId){
        Comic NComic = comicRepository.findById(comicId).get();
        Comentarios NComent = comentariosRepository.findById(comentarioId).get();
        Set<Comentarios> LComents = NComic.getComentarios();
        LComents.add(NComent);
        NComic.setComentarios(LComents);
        comicRepository.save(NComic);
    }

    public void ActualizarLikesComentario(Long comentarioId){
        Comentarios coment = comentariosRepository.findById(comentarioId).get();
        coment.setLikes(coment.getLikes() + 1);
    }
    public void ActualizarDisLikesComentario(Long comentarioId){
        Comentarios coment = comentariosRepository.findById(comentarioId).get();
        coment.setDislikes(coment.getDislikes() + 1);
    }
    public void ActializarLikesComic(Long comicId){
        Comic comic= comicRepository.findById(comicId).get();
        comic.setLikes(comic.getLikes() + 1);
    }
    public void ActializarDisLikesComic(Long comicId){
        Comic comic= comicRepository.findById(comicId).get();
        comic.setDislikes(comic.getDislikes() + 1);
    }

    //get comi

    public AllComicsResponse MakeComicResponse(Comic comic){
        Set<Comentarios> ComicComentarios = comic.getComentarios();
        Set<ComentarioComicResponse> ComentariosResponse = new HashSet<>();
        for(Comentarios c: ComicComentarios){
            ComentariosResponse.add(new ComentarioComicResponse(c.getId(),c.getContenido(),c.getLikes(),c.getDislikes(),c.getUser().getNombre()));
        }
        List<Temporada> TemporadasComic= comic.getTemporadas();
        List<TemporadaDTO> TemporadasResponse= new ArrayList<>();
        for(Temporada t: TemporadasComic){
            TemporadasResponse.add(new TemporadaDTO(t.getId(),t.getNombre(),t.getDescripcion(),t.getUrl()));
        }
        return new AllComicsResponse(comic.getId(), comic.getEstado(), comic.getNombre(), comic.getFecha_de_publicación(), comic.getDescripcion(), comic.getImagenes_description(), comic.getPrecio(), comic.getLikes(), comic.getDislikes(), comic.getGeneros(),comic.getAutor().getId(), comic.getUser().getNombre(), ComentariosResponse, TemporadasResponse);

    }


    public List<AllComicsResponse> getComics(){
        List<Comic> comics = comicRepository.findAll();
        List<AllComicsResponse> Output = new ArrayList<>();
        for(Comic c: comics){
            Output.add(MakeComicResponse(c));
        }
        return Output;
    }

    public Optional<Comic> getComicicito(Long id){
        return comicRepository.findById(id);
    }

    //eSTE SI: 
    public List<ComicDto> getComentariosPorComic() {
        List<Comic> comics = comicRepository.findAll();
        return comics.stream().map(ComicDto::new).collect(Collectors.toList());
    }
}