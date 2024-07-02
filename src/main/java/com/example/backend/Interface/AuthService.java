package com.example.backend.Interface;

import com.example.backend.Model.User;
import com.example.backend.dto.SignupRequest;

public interface AuthService {
    User createCustomer(SignupRequest signupRequest);
}