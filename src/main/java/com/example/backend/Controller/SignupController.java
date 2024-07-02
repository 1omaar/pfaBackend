package com.example.backend.Controller;


import com.example.backend.Interface.AuthService;
import com.example.backend.Model.User;
import com.example.backend.dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        try {
            User createdCustomer = authService.createCustomer(signupRequest);
            if (createdCustomer != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the customer");
        }
    }


}
