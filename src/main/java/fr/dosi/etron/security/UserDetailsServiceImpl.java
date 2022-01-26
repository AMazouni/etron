package fr.dosi.etron.security;

import fr.dosi.etron.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fr.dosi.etron.jpa.User appUser=userDao.findByUsername(username);
        if(appUser==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.RoleList().forEach(r->{
            authorities.add(new SimpleGrantedAuthority((String) r));
        });
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}
