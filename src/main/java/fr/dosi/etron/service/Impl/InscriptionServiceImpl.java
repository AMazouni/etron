package fr.dosi.etron.service.Impl;


import fr.dosi.etron.dao.ClientDAO;
import fr.dosi.etron.dao.RolesDAO;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.Role;
import fr.dosi.etron.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class InscriptionServiceImpl {

    @Autowired
    UserDAO userDao;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RolesDAO roleDAO;

   public User register(User user){
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       Role role=roleDAO.findById(1l).get();
       List<Role> roles= Arrays.asList(role);
       user.setRoles(roles);
       System.out.println(user);
       userDao.save(user);
       user.setPassword(null);

       return user;
   }


}
