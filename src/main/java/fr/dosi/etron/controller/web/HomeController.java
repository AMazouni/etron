package fr.dosi.etron.controller.web;

import fr.dosi.etron.jpa.User;
import fr.dosi.etron.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

   /* @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }





}
