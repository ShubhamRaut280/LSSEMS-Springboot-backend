package com.shubham.localservices.Services.Interfaces;

import com.shubham.localservices.Models.AuthRequest;
import com.shubham.localservices.Models.AuthResponse;
import com.shubham.localservices.Models.Db.User;

public interface AuthServiceInterface {
    AuthResponse login(AuthRequest request);
    Long register(User user);
}
