package com.example.controllers;

import com.example.model.RegisterForm;
import com.example.model.User;
import com.example.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // loads register.html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRole(form.getRole());
        repo.save(user);
        return "redirect:/login";
    }
}
