package com.vijay.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.dto.AuthRequestDto;
import com.vijay.dto.JwtResponseDto;
import com.vijay.dto.RegisterRequestDto;
import com.vijay.payload.ApiResponse;
import com.vijay.security.JwtUtil;
import com.vijay.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody RegisterRequestDto request) {
        userService.registerAdmin(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Admin registered", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtResponseDto>> login(@RequestBody AuthRequestDto request) throws AccessDeniedException {
    	
        System.out.println("Username: " + request.getUsername());
        System.out.println("Password: " + request.getPassword());
    	
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        userService.validateAdminLogin(request.getUsername());

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Login successful", new JwtResponseDto(token))
        );
    }
}

