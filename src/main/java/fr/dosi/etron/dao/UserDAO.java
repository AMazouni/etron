package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Client;
import fr.dosi.etron.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RepositoryRestResource(path = "userRest",collectionResourceRel = "User")
public interface UserDAO extends JpaRepository<User,Long> {
    User findByEmail(String email);
    List<User> findByClient(Client client);
    Boolean existsByClient(Client client);

}
