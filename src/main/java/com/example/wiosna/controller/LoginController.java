package com.example.wiosna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "message", required = false) String message,
            Model model) {
        if ( message!=null){
            model.addAttribute("message",message);
        }

        if (error != null) {
            model.addAttribute("errorMessage", "Nieprawidłowa nazwa użytkownika lub hasło!");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Pomyślnie wylogowano!");
        }
        return "login";
    }
}