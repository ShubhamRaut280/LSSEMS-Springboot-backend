package com.shubham.localservices.Controllers;

import com.shubham.localservices.Models.AuthRequest;
import com.shubham.localservices.Models.AuthResponse;
import com.shubham.localservices.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        return new ResponseEntity<>(authService.login(request), OK);
    }

}