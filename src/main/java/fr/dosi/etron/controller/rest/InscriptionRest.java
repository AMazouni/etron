package fr.dosi.etron.controller.rest;


import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.service.Impl.InscriptionServiceImpl;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ser-inscription/")
public class InscriptionRest {

    @Autowired
    InscriptionServiceImpl inscriptionService;

    @GetMapping
    public List<User> getAll() {
        return inscriptionService.getAll();
    }
    @GetMapping("/{email}")
    public ResponseEntity findByEmail(@PathVariable String email)  {

        try {
            return new ResponseEntity<User>(inscriptionService.findByEmail(email), HttpStatus.OK);
        }catch (ResourcesNotFoundFault e){
            return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.NOT_FOUND);
        }
    }

    public List<User> saveAll(Iterable<User> entities) {
        return inscriptionService.saveAll(entities);
    }

    @Transactional
    @PostMapping
    public ResponseEntity save(User entity)  {

        try {
            return new ResponseEntity<User>(inscriptionService.save(entity), HttpStatus.OK);
        }catch (EmptyRessourceFault e){
            return new ResponseEntity<EmptyRessourceFault>(e, HttpStatus.BAD_REQUEST);

        }catch (DuplicateEntityFault e){
            return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id)  {
        try {
            return new ResponseEntity<User>(inscriptionService.findById(id), HttpStatus.OK);
        }catch (ResourcesNotFoundFault e){
            return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public long count() {
        return inscriptionService.count();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        inscriptionService.deleteById(id);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegistrationDTO user, HttpServletResponse response) throws EmptyRessourceFault, DuplicateEntityFault {
       try {
           return new ResponseEntity<User>(inscriptionService.register(user), HttpStatus.OK);
       }catch (EmptyRessourceFault e){
             return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.BAD_REQUEST);

       }catch (DuplicateEntityFault e){
           return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.BAD_REQUEST);

       }
    }
}
