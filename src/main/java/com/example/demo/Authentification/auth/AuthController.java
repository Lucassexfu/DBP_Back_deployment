package com.example.demo.Authentification.auth;

import com.example.demo.Authentification.user.UserRequestDto;
import com.example.demo.Authentification.user.SigninRequest;
import org.springframework.beans.factory.   annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
