package com.example.demo.dtos;

public class LoginResponseDto {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

    public LoginResponseDto setToken(String token) {
        this.token = token;
        return this;
    }

    public Long setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
        return this.expiresIn;
    }
    // Getters and setters...
}
