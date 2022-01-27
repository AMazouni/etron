package fr.dosi.etron.controller.rest;


import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.service.Impl.InscriptionServiceImpl;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/ser-inscription/")
public class InscriptionRest {

    @Autowired
    InscriptionServiceImpl inscriptionService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegistrationDTO user, HttpServletResponse response) throws EmptyRessourceFault, DuplicateEntityFault {
       try {
           return new ResponseEntity<User>(inscriptionService.register(user), HttpStatus.OK);
       }catch (EmptyRessourceFault e){
             return new ResponseEntity<EmptyRessourceFault>(e, HttpStatus.BAD_REQUEST);

       }catch (DuplicateEntityFault e){
           return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.BAD_REQUEST);

       }
    }
}
