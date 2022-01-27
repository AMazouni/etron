package fr.dosi.etron.service.ifc;


import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.User;

import javax.transaction.Transactional;
import java.util.List;

public interface InscriptionService {


    @Transactional
    User register(UserRegistrationDTO registrationDto) throws EmptyRessourceFault, DuplicateEntityFault;

    List<User> getAll();

    User findByEmail(String email) throws ResourcesNotFoundFault;

    List<User> saveAll(Iterable<User> entities);

    @Transactional
    User save(User entity) throws DuplicateEntityFault, EmptyRessourceFault;

    User findById(Long aLong) throws ResourcesNotFoundFault;

    long count();
}
