package com.oasis.onlinereservationsystem.controller;

import com.oasis.onlinereservationsystem.model.User;
import com.oasis.onlinereservationsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {


    private UserService userService;

    @GetMapping("/login")
    public String sendLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user")User user, Model model){
        boolean usernameAndPasswordExist = userService.isUsernameAndPasswordExist(user.getUsername(), user.getPassword());
        if(usernameAndPasswordExist){
            return "index";
        }
        model.addAttribute("error", "Incorrect Username or Password");
        return "login";
    }

    @GetMapping("/reservation")
    public String reservation(){
        return "reservation";
    }

    @GetMapping("/cancel-form")
    public String cancel(){
        return "cancel-ticket";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
