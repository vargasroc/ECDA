package com.Roc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Renderiza la vista de inicio de sesión
    }

    @GetMapping("/oauth2/callback/google")
    public String googleCallback() {
        // Maneja la redirección después de la autenticación exitosa
        return "redirect:/dashboard"; // Redirige al panel de control del usuario
    }
}
