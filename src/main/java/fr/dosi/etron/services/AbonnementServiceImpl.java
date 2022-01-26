package fr.dosi.etron.services;

import fr.dosi.etron.dao.AbonnementDAO;
import fr.dosi.etron.jpa.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService{
    @Autowired
    AbonnementDAO abonnementDAO;
    @Override
    public Abonnement save(Abonnement abonnement) {
        return abonnementDAO.save(abonnement);
    }

    @Override
    public List<Abonnement> getAll() {
        return abonnementDAO.findAll();
    }
}
