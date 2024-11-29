package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.AuthenticationService;
import com.example.demo.dtos.LoginResponseDto;
import com.example.demo.dtos.LoginUserDto;
import com.example.demo.dtos.RegisterUserDto;
import com.example.demo.entities.User;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {
   

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        LoginResponseDto loginResponse = new LoginResponseDto();

        String username=authenticatedUser.getUsername();
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }
}