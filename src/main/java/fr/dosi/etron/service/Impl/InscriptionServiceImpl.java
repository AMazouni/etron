package fr.dosi.etron.service.Impl;


import fr.dosi.etron.dao.ClientDAO;
import fr.dosi.etron.dao.UserDAO;
import fr.dosi.etron.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InscriptionServiceImpl {

@Autowired
UserDAO clientDao;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

   public User register(User user){
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       clientDao.save(user);
       user.setPassword(null);
       return user;
   }


}
