package fr.dosi.etron.service.Impl;

import fr.dosi.etron.dao.ContratDAO;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.service.ifc.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContratDAO contratDAO;

    @Autowired
    UserDAO userDao;

    @Override
    public Contrat save(Contrat contrat) {
        contratDAO.save(contrat);
        return contrat;
    }

    @Override
    public List<Contrat> getAll() {
        return contratDAO.findAll();
    }

    @Override
    public Optional<Contrat> findById(Long id) {
        return contratDAO.findById(id);
    }

    @Override
    public Contrat findByClient(Long id) {
        return (Contrat) contratDAO.findByUserId(id);
    }


}
