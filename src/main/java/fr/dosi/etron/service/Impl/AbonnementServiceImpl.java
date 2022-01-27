package fr.dosi.etron.service.Impl;

import fr.dosi.etron.dao.AbonnementDAO;
import fr.dosi.etron.dao.ContratDAO;
import fr.dosi.etron.dto.AbonnementDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.service.ifc.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService {
    @Autowired
    AbonnementDAO abonnementDAO;
    @Autowired
    ContratDAO contratDAO;

    @Override
    public Contrat sabonner(AbonnementDTO AbonnementDTO) throws EmptyRessourceFault, DuplicateEntityFault {
        return null;
    }

    @Override
    public User findByEmail(String email) throws ResourcesNotFoundFault {
        return null;
    }

    @Override
    public List<User> saveAll(Iterable<User> entities) {
        return null;
    }

    @Override
    public Contrat save(Contrat entity) throws DuplicateEntityFault, EmptyRessourceFault {
        return null;
    }

    @Override
    public Abonnement save(Abonnement abonnement) {
        return abonnementDAO.save(abonnement);
    }

    @Override
    public User findById(Long aLong) throws ResourcesNotFoundFault {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Abonnement> getAll() {
        return abonnementDAO.findAll();
    }
}
