package com.example.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.ShiftService;
import com.example.service.impl.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ViewController {

    private ShiftService shiftService;
    private UserService userService;

    // ✅ LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";  // Loads src/main/resources/templates/login.html
    }

    // ✅ LOGIN FORM SUBMISSION
    @PostMapping("/perform_login")
    public String processLogin() {
        return "redirect:/page01";  // Redirect after successful login
    }

    // ✅ OTHER PAGES
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("username", "John Doe");
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";  // Loads src/main/resources/templates/signup.html
    }

    @GetMapping("/page02")
    public String page02() {
        return "page02";
    }

    @GetMapping("/page03")
    public String page03(Model model) {
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("now", date);
        return "page03";
    }

    @GetMapping("/page04")
    public String page04(Model model) {
        model.addAttribute("shift1", shiftService.getSampleById(1));
        model.addAttribute("shift2", shiftService.getSampleById(2));
        model.addAttribute("shift3", shiftService.getSampleById(3));
        return "page04";
    }

    // ✅ CREATE USER ENDPOINT (For manual user creation)
    @GetMapping("/create_user/{username}/{password}")
    public void createUser(@PathVariable("username") String username, 
                           @PathVariable("password") String password) {
        userService.create(username, password);
    }
}
