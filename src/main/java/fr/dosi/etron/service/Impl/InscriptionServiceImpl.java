package fr.dosi.etron.service.Impl;


import fr.dosi.etron.dao.ClientDAO;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.jpa.Client;
import fr.dosi.etron.jpa.Role;
import fr.dosi.etron.jpa.User;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.service.ifc.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    ClientDAO clientDAO;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public User register(UserRegistrationDTO registrationDto) throws EmptyRessourceFault, DuplicateEntityFault {
        String firstname=registrationDto.getFirstName();
        String lastname=registrationDto.getLastName();
        String email=registrationDto.getEmail();
        String password=bCryptPasswordEncoder.encode(registrationDto.getPassword());
        List<Role> roles= Arrays.asList(new Role("Client"));
        Client client= new Client(lastname,firstname,"","","",new Date(),null);
        Client dBClient = clientDAO.findByNomAndPrenom(client.getNom(),client.getPrenom());
        User user=new User(firstname,lastname,email,password,roles,client);
        registrationDto.setPassword(null);
        if(dBClient==null) clientDAO.save(client);
        if(dBClient!=null && userDAO.existsByClient(dBClient)) throw new DuplicateEntityFault(registrationDto,"Le Client a deja un compte");

        return this.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByEmail(String email) throws ResourcesNotFoundFault {
        User u= userDAO.findByEmail(email);
        if(u != null) throw new ResourcesNotFoundFault(email);
        return userDAO.findByEmail(email);
    }
    @Override
    public List<User> saveAll(Iterable<User> entities) {
        return userDAO.saveAll(entities);
    }

    @Transactional
    @Override
    public User save(User entity) throws DuplicateEntityFault, EmptyRessourceFault {
        if(userDAO.findByEmail(entity.getEmail())!=null)  throw new DuplicateEntityFault(entity,"User Email Duplicate");
        if(entity.getEmail()==null || entity.getPassword()==null || entity.getRoles()==null || entity.getFirstName()==null || entity.getLastName()==null ) throw new EmptyRessourceFault(entity);

        if(entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getFirstName().isEmpty() || entity.getLastName().isEmpty() )  throw new EmptyRessourceFault(entity);
        return userDAO.save(entity);
    }
    @Override
    public User findById(Long aLong) throws ResourcesNotFoundFault {
        Optional<User> u = userDAO.findById(aLong);
        if(!u.isPresent()) throw new ResourcesNotFoundFault(aLong);
        return u.get();
    }
    @Override
    public long count() {
        return userDAO.count();
    }

    @Transactional
    public void deleteById(Long aLong) {
        userDAO.deleteById(aLong);
    }


}
