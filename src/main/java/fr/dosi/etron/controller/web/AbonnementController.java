package fr.dosi.etron.controller.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.jpa.Client;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.security.SecurityParams;
import fr.dosi.etron.service.ifc.AbonnementService;
import fr.dosi.etron.service.ifc.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Map;

@Controller
@RequestMapping("/abonnement")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private UserDAO userDAO;


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
    public String abonnementAdd(@ModelAttribute("abonnement") Abonnement abonnement,@RequestParam String jwt,@RequestBody Map<String, String> data){
        System.out.println("frais++>"+data.get("frais"));
        System.out.println("frais++>"+data.get("type"));
        abonnement.setFrais(data.get("frais"));
        abonnement.setType(data.get("type"));
        Calendar cal = Calendar.getInstance();
        Calendar  date = cal;
        int months= cal.get(Calendar.MONTH) + 12;
        //Calendar dateFin=cal.set(2022,months);
        DecodedJWT jwtt = JWT.decode(jwt);
        String email=jwtt.getSubject();
        User user=userDAO.findByEmail(email);
        Client client=user.getClient();
        System.out.println("JWT++> "+jwt);

        System.out.println("USER++> "+user);
        System.out.println("DATE++> "+date  );

        System.out.println("CLIENT++> "+client);
        Contrat contrat=new Contrat(date,date,client,abonnement);
        abonnementService.save(abonnement);
        contractService.save(contrat);
        return "redirect:/contrat?jwt="+jwt;
    }
}
