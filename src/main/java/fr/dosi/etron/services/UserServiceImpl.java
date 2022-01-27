package fr.dosi.etron.services;

import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.exceptions.DuplicateEntityFault;
import fr.dosi.etron.exceptions.EmptyRessourceFault;
import fr.dosi.etron.exceptions.ResourcesNotFoundFault;
import fr.dosi.etron.jpa.Role;
import fr.dosi.etron.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;

    @Autowired
        private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User save(UserRegistrationDTO registrationDto) {
        String firstname=registrationDto.getFirstName();
        String lastname=registrationDto.getLastName();
        String email=registrationDto.getEmail();
        String password=passwordEncoder.encode(registrationDto.getPassword());
        List<Role> roles= Arrays.asList(new Role("Client"));
        User user=new User(firstname,lastname,email,password,roles);
        return userDAO.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }


    public User findByEmail(String email) throws ResourcesNotFoundFault {
        User u= userDAO.findByEmail(email);
        if(u != null) throw new ResourcesNotFoundFault(email);
        return userDAO.findByEmail(email);
    }

    public List<User> saveAll(Iterable<User> entities) {
        return userDAO.saveAll(entities);
    }
    @Transactional
    public User save(User entity) throws DuplicateEntityFault, EmptyRessourceFault {
        if(userDAO.findByEmail(entity.getEmail())!=null)  throw new DuplicateEntityFault(entity,"email");
        if(entity.getEmail()==null || entity.getPassword()==null || entity.getRoles()==null || entity.getFirstName()==null || entity.getLastName()==null ) throw new EmptyRessourceFault(entity);

        return userDAO.save(entity);
    }

    public User findById(Long aLong) throws ResourcesNotFoundFault {
        Optional<User> u = userDAO.findById(aLong);
        if(!u.isPresent()) throw new ResourcesNotFoundFault(aLong);
        return u.get();
    }

    public long count() {
        return userDAO.count();
    }

    @Transactional
    public void deleteById(Long aLong) {
        userDAO.deleteById(aLong);
    }

///////////////////////////////////////////////////////////////////SECURITY/////////////////////////////////////////////////////////////////

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDAO.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("invalide username or passord");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
