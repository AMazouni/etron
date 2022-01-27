package fr.dosi.etron.controller.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.security.SecurityParams;
import fr.dosi.etron.service.ifc.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/abonnement")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;


    @ModelAttribute("abonnement")
    public Abonnement abonnement(){return new Abonnement();}

    @GetMapping
    public String showAbonnementRegistrationForm(@RequestParam String jwt){
        System.out.println(jwt);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();
        try {
            System.out.println(verifier.verify(jwt));
        }catch(Exception e){
            return "login";
        }
        return "abonnement";
    }

    @PostMapping
    public String abonnementAdd(@ModelAttribute("abonnement") Abonnement abonnement){
        abonnementService.save(abonnement);
        return "redirect:/abonnement?success";
    }
}
