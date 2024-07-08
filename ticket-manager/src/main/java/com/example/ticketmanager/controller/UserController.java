package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.User;
import com.example.ticketmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.authenticateUser(username, password);
        if (user != null) {
            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
