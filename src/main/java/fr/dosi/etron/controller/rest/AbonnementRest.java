package fr.dosi.etron.controller.rest;

import antlr.StringUtils;
import fr.dosi.etron.dto.AbonnementDTO;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.service.ifc.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ser-abonnement/")
public class AbonnementRest {
    @Autowired
    AbonnementService aboser;

    @Transactional
    @PostMapping("/")
    public ResponseEntity sabonner(@RequestBody AbonnementDTO abonnementDTO, @RequestHeader(name="Authorization") Map<String,String> headers)  {
       //
        String jwt=getjwt(headers);
        try {
            return new ResponseEntity<Contrat>(aboser.sabonner(abonnementDTO, jwt),HttpStatus.OK);
        }catch (EmptyRessourceFault e){
            return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.BAD_REQUEST);
        }catch (ResourcesNotFoundFault e){
            return new ResponseEntity<Map<String,Object>>(e.getBody(), HttpStatus.NOT_FOUND);

        }

    }

    public List<Contrat> getMyContrats(String jwt) throws ResourcesNotFoundFault {
        return aboser.getMyContrats(jwt);
    }

    public Contrat resilierContrat(Long id, String jwt) throws ResourcesNotFoundFault {
        return aboser.resilierContrat(id, jwt);
    }

    public String getjwt(Map<String,String> headers){
        return headers.get("authorization").substring(7);
    }
}
