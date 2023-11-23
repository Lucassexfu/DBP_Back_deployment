package com.example.demo.Authentification.auth;

import com.example.demo.infraestructure.usuarioRepository;
import com.example.demo.Authentification.user.UserRequestDto;
import com.example.demo.domain.entities.Usuario;
import com.example.demo.Authentification.role.Role;
import com.example.demo.Authentification.user.SigninRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
// SignUpRequest se reemplazo por UserRequestDto, se cambio el signin por Username
@Service
public class AuthenticationService {
    private final usuarioRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(usuarioRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signup(UserRequestDto request) {

        var user = new Usuario();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setPuntos(request.getPuntos());
        user.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        //System.out.println(request.getIsAdmin() );
        if(request.getIsAdmin().equals("true"))
            user.setRole(Role.ADMIN);
        else
            user.setRole(Role.USER);


        userRepository.save(user);
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);

        return response;
    }

    public JwtAuthenticationResponse signin(SigninRequest request) throws IllegalArgumentException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByNombre(request.getUsername());
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);
        System.out.println("Hola, mundo!");
        return response;
    }
}
