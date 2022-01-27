package fr.dosi.etron.controller.rest;


import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.service.Impl.InscriptionServiceImpl;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ser-inscription/")
public class InscriptionRest {

    @Autowired
    InscriptionServiceImpl inscriptionService;


    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationDTO user) throws EmptyRessourceFault, DuplicateEntityFault {
        return inscriptionService.register(user);
    }
}
