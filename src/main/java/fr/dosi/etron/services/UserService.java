package fr.dosi.etron.services;

import fr.dosi.etron.jpa.User;
import fr.dosi.etron.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO registrationDto);
    List<User> getAll();

}
