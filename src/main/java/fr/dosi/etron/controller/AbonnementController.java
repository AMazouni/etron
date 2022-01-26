package fr.dosi.etron.controller;

import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/abonnement")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;


    @ModelAttribute("abonnement")
    public Abonnement abonnement(){return new Abonnement();}

    @GetMapping
    public String showAbonnementRegistrationForm(){
        return "abonnement";
    }

    @PostMapping
    public String abonnementAdd(@ModelAttribute("abonnement") Abonnement abonnement){
        abonnementService.save(abonnement);
        return "redirect:/abonnement?success";
    }
}
