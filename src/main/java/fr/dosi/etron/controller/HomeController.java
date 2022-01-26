package fr.dosi.etron.controller;

import fr.dosi.etron.jpa.User;
import fr.dosi.etron.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserService userService;

   /* @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    @GetMapping("/")
    public String home(){
        return "abonnement";
    }

    @GetMapping("/users")
    public List<User> users(){
       List<User> users= userService.getAll();
        return users;
    }



}
