package com.example.demo.Authentification.user;

import com.example.demo.Authentification.mapper;
import com.example.demo.domain.entities.Usuario;
import com.example.demo.infraestructure.usuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Service
public class UserService {

    private usuarioRepository userRepository;
    @Autowired
    public UserService(usuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    /* POST- ya hay un createUser en AutenticationService
    public void addUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setLastname(userRequestDto.getLastname());
        user.setPoints(userRequestDto.getPoints());
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());

        User userSaved = userRepository.save(user);
        return;
    }*/
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByNombre(username);
            }
        };
    }

    // GET BY ID
    public UserResponseDto getUserById(Long id) {
        Usuario user = userRepository.findById(id).get();
        return mapper.userToUserResponseDto(user);
    }
    // GET ALL
    public List<UserResponseDto> getUsers() {
        List<Usuario> users = userRepository.findAll();
        return mapper.userResponseDtoList(users);
    }

    public Usuario getUser(Long userId) {
        return userRepository.findById(userId).get();
    }
}
