package fr.dosi.etron.service.ifc;


import fr.dosi.etron.jpa.Contrat;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Contrat save(Contrat contrat);
    List<Contrat> getAll();
    Optional<Contrat> findById(Long id);
    List<Contrat> findByClient(Long id);

}
