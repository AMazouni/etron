package fr.dosi.etron.controller.web;

import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService){
        super();
        this.userService=userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO() ;
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @GetMapping("users")
    public List<User> users(){
        List<User> users= userService.getAll();
        return users;
    }

    /*@PostMapping
    public ResponseEntity<UserRegistrationDTO> registerUserAccount(@RequestBody UserRegistrationDTO userRegistrationDTO){
        userService.save(userRegistrationDTO);
        HttpHeaders headers=new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(userRegistrationDTO) ;
    }*/
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO){
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }
}
