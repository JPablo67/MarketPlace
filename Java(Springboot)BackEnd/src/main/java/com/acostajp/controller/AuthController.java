package com.acostajp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acostajp.model.LoginResponse;
import com.acostajp.model.Product;
import com.acostajp.model.User;
import com.acostajp.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");

        int userType = userService.findLogin(email, password);
        LoginResponse response = new LoginResponse();

        if (userType == 1) {
            response.setView("clienteView");
            response.setMessage("Login successful for Cliente");
        } else if (userType == 2) {
            response.setView("empleadoView");
            response.setMessage("Login successful for Empleado");
        } else if (userType == 3) {
            response.setView("adminView");
            response.setMessage("Login successful for Admin");
        } else {
            response.setView("loginPage");
            response.setMessage("Invalid credentials");
        }

        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/searching/{email}")
    public User findByEmail(@PathVariable String email) {
    	System.out.println(email);
    	return userService.findByEmail(email);
    	
    }
		
    


}
