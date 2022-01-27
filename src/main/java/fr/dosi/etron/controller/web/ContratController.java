package fr.dosi.etron.controller.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import fr.dosi.etron.dao.ContratDAO;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.security.SecurityParams;
import fr.dosi.etron.service.ifc.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/contrat",params="jwt")
public class ContratController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContratDAO contratDAO;
    @Autowired
    private UserDAO userDAO;

    @ModelAttribute("contrat")
    public List<Contrat> Contrat(@RequestParam String jwt) {
        System.out.println("TTTTT+++>"+jwt);
        return this.getContract(jwt);
    }

    @GetMapping
    public String showContrat(){
        return "contrat";
    }

    public List<Contrat> getContract(String jwt){
        DecodedJWT jwtt = JWT.decode(jwt);
        String email=jwtt.getSubject();
        User user=userDAO.findByEmail(email);
        System.out.println("EMAIL=" + email);
        return (List<Contrat>) contractService.findByClient(user.getId());
    }
    @PostMapping
    public Contrat saveContract(Contrat contrat){
        return contractService.save(contrat);
    }
}
