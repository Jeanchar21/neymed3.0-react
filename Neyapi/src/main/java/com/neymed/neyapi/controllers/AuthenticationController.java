package com.neymed.neyapi.controllers;

import com.neymed.neyapi.DTO.AuthenticationDTO;
import com.neymed.neyapi.DTO.LoginResponseDTO;
import com.neymed.neyapi.DTO.RegisterDTO;
import com.neymed.neyapi.infra.security.TokenService;
import com.neymed.neyapi.models.Admins;
import com.neymed.neyapi.repositories.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AdminRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Admins) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Admins> register(@RequestBody @Valid RegisterDTO data){

        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(data.password());
        Admins newUser = new Admins(data.login(), encryptedPassword, data.perfil());

        this.repository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
