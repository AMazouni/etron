package fr.dosi.etron.ws.rest.provided;


import fr.dosi.etron.jpa.User;
import fr.dosi.etron.service.Impl.InscriptionServiceImpl;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class InscriptionRest {

    @Autowired
    InscriptionServiceImpl inscriptionService;


    @PostMapping("/")
    public User register(@RequestBody User user) {
        return inscriptionService.register(user);
    }
}
