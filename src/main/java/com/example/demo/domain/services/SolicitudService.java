package com.example.demo.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.DTOs.CambiarSolicitudDTO;
import com.example.demo.domain.DTOs.ModificarSolicitudDTO;
import com.example.demo.domain.DTOs.RequestSolicitudDTO;
import com.example.demo.domain.entities.Solicitud;
import com.example.demo.domain.entities.Usuario;
import com.example.demo.infraestructure.SolicitudRepository;
import com.example.demo.infraestructure.comicRepository;
import com.example.demo.infraestructure.usuarioRepository;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudesRepository;
    @Autowired
    private usuarioRepository usuarioRepository;
    @Autowired
    private comicRepository comicRepository;

    public String guardarSolicitud(RequestSolicitudDTO solicitud){
        List<Long> solicitanteList = new ArrayList<>();
        for(String sComic: solicitud.getComics()){
            solicitanteList.add(comicRepository.findByNombre(sComic).get().getId());
        }
        Solicitud sol = new Solicitud();
        sol.setDescripcion(solicitud.getOcupacion());
        sol.setOcupacion(solicitud.getOcupacion());
        sol.setFecha(solicitud.getFecha());
        Usuario UsuarioSolicitante = usuarioRepository.findByNombre(solicitud.getNombre()); 
        sol.setUsuario_asking(UsuarioSolicitante);
        sol.setComics_ids(solicitanteList);
        Solicitud solSaved = solicitudesRepository.save(sol);
        List <Solicitud> solis = UsuarioSolicitante.getSolicitudes();
        solis.add(solSaved);
        usuarioRepository.save(UsuarioSolicitante);
        return "Solicitud enviada";

    }

    public List<RequestSolicitudDTO> VerSolicitudes(){
        List<Solicitud> sols = solicitudesRepository.findAll();
        List<RequestSolicitudDTO> solsSalida = new ArrayList<>();
        for(Solicitud s: sols){
            List<String> comics = new ArrayList<>();
            for(Long c: s.getComics_ids()){
                comics.add(comicRepository.findById(c).get().getNombre());
            }
            solsSalida.add(new RequestSolicitudDTO(s.getDescripcion(), s.getOcupacion(), s.getFecha(), s.getUsuario_asking().getNombre(), comics));
        }
        return solsSalida;
    }
    public RequestSolicitudDTO VerSolicitudesIdUser(Long user_id){
        Solicitud sols = solicitudesRepository.findById(user_id).get();
        List<String> comics = new ArrayList<>();
        for(Long c: sols.getComics_ids()){
            comics.add(comicRepository.findById(c).get().getNombre());
        }
        return new RequestSolicitudDTO(sols.getDescripcion(),sols.getOcupacion(), sols.getFecha(), sols.getUsuario_asking().getNombre(),comics);
    }
    public RequestSolicitudDTO EliminarSolicitud(Long id){
        Solicitud sols = solicitudesRepository.findById(id).get();
        List<String> comics = new ArrayList<>();
        for(Long c: sols.getComics_ids()){
            comics.add(comicRepository.findById(c).get().getNombre());
        }
        solicitudesRepository.deleteById(id);
        return new RequestSolicitudDTO(sols.getDescripcion(),sols.getOcupacion(), sols.getFecha(), sols.getUsuario_asking().getNombre(),comics);
    }
    public ModificarSolicitudDTO Modificar(ModificarSolicitudDTO cambio, String Nombre){
        Usuario modU = usuarioRepository.findByNombre(Nombre);
        Solicitud tempSol = modU.getSolicitudes().get(0);
        tempSol.setDescripcion(cambio.getDescripcion());
        tempSol.setOcupacion(cambio.getPuesto());
        solicitudesRepository.save(tempSol);
        List<Solicitud> mdList = new ArrayList<>();
        mdList.add(tempSol);
        modU.setSolicitudes(mdList);
        return cambio;
    }
    public CambiarSolicitudDTO Cambiar(CambiarSolicitudDTO change, String Nombre){
        Solicitud PastSolicitud = solicitudesRepository.findById(usuarioRepository.findByNombre(Nombre).getId()).get();
        solicitudesRepository.save(new Solicitud(PastSolicitud.getId(), change.getDescripcion(), change.getOcupacion(), change.getFecha(), change.getComics_ids(), PastSolicitud.getUsuario_asking()));
        return change;
    }
}
