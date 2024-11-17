package com.shubham.localservices.Services.Interfaces;

import com.shubham.localservices.Models.AuthRequest;
import com.shubham.localservices.Models.AuthResponse;

public interface AuthServiceInterface {
    AuthResponse login(AuthRequest request);
}
