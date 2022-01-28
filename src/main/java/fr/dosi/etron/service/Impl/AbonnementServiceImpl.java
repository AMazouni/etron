package fr.dosi.etron.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import fr.dosi.etron.dao.AbonnementDAO;
import fr.dosi.etron.dao.ContratDAO;
import fr.dosi.etron.dao.VoitureDAO;
import fr.dosi.etron.dto.AbonnementDTO;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.*;
import fr.dosi.etron.service.ifc.AbonnementService;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AbonnementServiceImpl implements AbonnementService {
    @Autowired
    AbonnementDAO abonnementDAO;
    @Autowired
    ContratDAO contratDAO;
    @Autowired
    InscriptionService insSer;
    @Autowired
    VoitureDAO voitureDao;

    @Override
    public Contrat sabonner(AbonnementDTO abonnementDTO,String jwt) throws ResourcesNotFoundFault {
        try {

            DecodedJWT jwtt = JWT.decode(jwt);
        String email=jwtt.getSubject();
        User u = insSer.findByEmail(email);
        Client c = u.getClient();
        abonnementDTO.setClientID(c.getId());
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String datedebut=dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DATE, 12);
            String dateFin=dateFormat.format(calendar.getTime());
        Abonnement a = abonnementDAO.findFirstByType(abonnementDTO.getTypeAbonnement());
        Contrat contrat = new Contrat(datedebut,dateFin,c,a);

        if( a==null)throw new ResourcesNotFoundFault(abonnementDTO,"Pas d'abonnement disponible de type"+abonnementDTO.getTypeAbonnement());
        if(c==null)throw new ResourcesNotFoundFault(abonnementDTO,"Pas de client avec l'emæil "+email);
        contratDAO.save(contrat);
        return contrat;

        }catch(JWTDecodeException e ){
            throw new ResourcesNotFoundFault(jwt,"Some kind of exception");
        }

    }

    @Override
    public List<Contrat> getMyContrats(String jwt) throws ResourcesNotFoundFault {
        try{
            DecodedJWT jwtt = JWT.decode(jwt);
        String email=jwtt.getSubject();
        User u = insSer.findByEmail(email);
        Client c = u.getClient();
        return this.findByClientId(c.getId());
        }catch(JWTDecodeException e ){
        throw new ResourcesNotFoundFault(jwt,"Some kind of exception");
    }
    }


    @Override
    public Contrat resilierContrat(Long id,String jwt) throws ResourcesNotFoundFault {
        try{
            List<Contrat> myContrat = getMyContrats(jwt);
            Contrat con=myContrat.stream().filter(c -> c.getId()==id).findFirst().get();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String datedebut=dateFormat.format(calendar.getTime());
            con.setDateFin(datedebut);
            return contratDAO.save(con);

        }catch(JWTDecodeException e ){
            throw new ResourcesNotFoundFault(jwt,"Some kind of exception");
        }catch(NoSuchElementException e){
            throw new ResourcesNotFoundFault(id,"no Contrat  corresponding to this contrat id");
        }
    }



////
    @Override
    public Contrat save(Contrat entity) throws  EmptyRessourceFault {

        if( entity.getAbonnement()==null)throw new EmptyRessourceFault(entity,"Pas d'abonnement ");
        if(entity.getClient()==null)throw new EmptyRessourceFault(entity,"Pas de client");

        return contratDAO.save(entity);
    }

    @Override
    public Abonnement save(Abonnement abonnement) {
        return abonnementDAO.save(abonnement);
    }

    @Override
    public User findById(Long aLong) throws ResourcesNotFoundFault {
        User cont=insSer.findById(aLong);
        if(cont==null ) throw new ResourcesNotFoundFault(aLong,"no User corresponding to this id");
        return cont;
    }

    @Override
    public List<Contrat> findByClientId(Long aLong) throws ResourcesNotFoundFault {
        List<Contrat> cont=contratDAO.findByClientId(aLong);
        if(cont==null || cont.size()==0) throw new ResourcesNotFoundFault(aLong,"no Contrat corresponding to this Client id");
        return cont;
    }

    @Override
    public long count() {
        return contratDAO.count();
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratDAO.findAll();
    }

    @Override
    public List<Abonnement> getAll() {
        return abonnementDAO.findAll();
    }
}
