package com.example.demo.Authentification;

import com.example.demo.Authentification.user.UserResponseDto;
import com.example.demo.domain.entities.Comentarios;
import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Aqui ta un cambio pa que se pushee//Aqui ta otro un cambio pa que se pushee
//Aqui otro 3 cambio +


public class mapper {

    // _________________USER_________________

    public static UserResponseDto userToUserResponseDto(Usuario user){
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setNombre(user.getNombre());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setDni(user.getDni());
        userResponseDto.setPuntos(user.getPuntos());

        List<Comic> comics = user.getComic_posteado();
        Set<Comentarios> comentarios = user.getComentarios();
        List<String> nombre_comics = new ArrayList<>();
        Set<String> contenido_comentarios = new HashSet<>();

        for(Comic comic : comics){
            nombre_comics.add(comic.getNombre());
        }
        for(Comentarios coment : comentarios){
            contenido_comentarios.add(coment.getContenido());
        }
        userResponseDto.setComentarios(contenido_comentarios);
        userResponseDto.setComic_posteados_nombres(nombre_comics);
        return userResponseDto;
    }   

    public static List<UserResponseDto> userResponseDtoList(List<Usuario> userList){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(Usuario user : userList){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto = userToUserResponseDto(user);
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }

}
