package fr.dosi.etron.service.ifc;

import fr.dosi.etron.dto.AbonnementDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.User;

import javax.transaction.Transactional;
import java.util.List;

public interface AbonnementService {
    @Transactional
    Contrat sabonner(AbonnementDTO AbonnementDTO,String jwt) throws EmptyRessourceFault, ResourcesNotFoundFault;



    List<User> saveAll(Iterable<User> entities);

    @Transactional
    Contrat save(Contrat entity) throws DuplicateEntityFault, EmptyRessourceFault;
    public Abonnement save(Abonnement abonnement);

    User findById(Long aLong) throws ResourcesNotFoundFault;

    Contrat findByClientId(Long aLong) throws ResourcesNotFoundFault;

    long count();
    public List<Contrat> getAllContrats();
    public List<Abonnement> getAll();
}
