package fr.dosi.etron.services;

import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.dto.UserRegistrationDTO;
import fr.dosi.etron.jpa.Role;
import fr.dosi.etron.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
        Collection<Role> roles= Arrays.asList(new Role("Admin"));
        User user=new User(firstname,lastname,email,password,roles);
        return userDAO.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

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
