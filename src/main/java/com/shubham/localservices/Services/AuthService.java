package com.shubham.localservices.Services;

import com.shubham.localservices.Models.AuthRequest;
import com.shubham.localservices.Models.AuthResponse;
import com.shubham.localservices.Models.Db.FreelancerProfile;
import com.shubham.localservices.Models.Db.User;
import com.shubham.localservices.Repository.FreelanceRepository;
import com.shubham.localservices.Repository.UserRepository;
import com.shubham.localservices.Services.Interfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService implements AuthServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FreelanceRepository freelanceRepository;


    @Override
    public AuthResponse login(AuthRequest request) {
        // login failed no email found
        if(request.getEmail() == null || request.getEmail().isEmpty()) return new AuthResponse(false, -1, "Email not found");

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            User curruser = user.get();
            int role = curruser.getRole();

            return new AuthResponse(true, role, "User found");
        }

        // user dosen't exist
        return new AuthResponse(false, -1, "User not found");
    }

    @Override
    public Long register(User user) {
        LocalDateTime currdate = LocalDateTime.now();
        user.setUpdatedAt(currdate);
        user.setCreatedAt(currdate);
        try {
            String email = user.getEmail();
            userRepository.save(user);
            Optional<User> saved = userRepository.findByEmail(email);
            if(saved.isPresent())return saved.get().getUserId();
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
            return -1L;
        }
        return -1L;
    }

    @Override
    public Long createFreelanceProfile(FreelancerProfile profile) {
        Long userid = profile.getUserId();
        Optional<User> user = userRepository.findById(userid);
        if(user.isPresent()){
            profile.setUser(user.get());
            freelanceRepository.save(profile);
            Optional<FreelancerProfile> res = freelanceRepository.findByuserId(userid);
            if(res.isPresent())return res.get().getProfileId();
        }
        return -1L;
    }
}
