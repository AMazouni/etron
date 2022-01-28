package fr.dosi.etron.controller.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.security.SecurityParams;
import fr.dosi.etron.service.ifc.ContractService;
import fr.dosi.etron.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private UserDAO userDAO;
    @GetMapping
    public List<Contrat> getContract(String jwt){
        DecodedJWT jwtt = JWT.decode(jwt);
        String email=jwtt.getSubject();
        User user=userDAO.findByEmail(email);
        System.out.println("EMAIL=" + email);
        return contractService.findByClient(user.getId());
    }
    @PostMapping
    public Contrat saveContract(Contrat contrat){
        return contractService.save(contrat);
    }
}
