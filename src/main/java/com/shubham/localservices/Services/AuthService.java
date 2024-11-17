package com.shubham.localservices.Services;

import com.shubham.localservices.Models.AuthRequest;
import com.shubham.localservices.Models.AuthResponse;
import com.shubham.localservices.Models.Db.Role;
import com.shubham.localservices.Models.Db.User;
import com.shubham.localservices.Repository.UserRepository;
import com.shubham.localservices.Services.Interfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements AuthServiceInterface {
    @Autowired
    private UserRepository userRepository;


    @Override
    public AuthResponse login(AuthRequest request) {
        // login failed no email found
        if(request.getEmail() == null || request.getEmail().isEmpty()) return new AuthResponse(false, -1, "Email not found");

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            User curruser = user.get();
            int role = -1;
            if(curruser.getRole() == Role.USER){
                role = 1;
            }else role = 2;

            return new AuthResponse(true, role, "User found");
        }

        // user dosen't exist
        return new AuthResponse(false, -1, "User not found");
    }
}