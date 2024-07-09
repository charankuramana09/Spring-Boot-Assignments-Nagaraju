package com.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeResource {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        return "home";
    }

    @GetMapping("/adminHome")
    public String adminHome(Model model) {
        model.addAttribute("title", "Admin Home Page");
        return "adminHome";
    }

    @GetMapping("/userHome")
    public String userHome(Model model) {
        model.addAttribute("title", "User Home Page");
        return "userHome";
    }
    @GetMapping("/login")
    public String handleLogin() {
    	return"custom_login";
    }
}
