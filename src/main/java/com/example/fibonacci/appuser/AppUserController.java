package com.example.fibonacci.appuser;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("/")
    public String getUsers(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String getLogin(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/registration")
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping("/users")
    public ResponseEntity addNewUser(@RequestBody AppUser appUser) {

        appUserService.signUpUser(appUser);
        return new ResponseEntity(HttpStatus.OK);
    }
}