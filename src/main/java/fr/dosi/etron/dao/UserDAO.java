package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.User;
import fr.dosi.etron.jpa.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "User",collectionResourceRel = "User")
public interface UserDAO extends JpaRepository<User,Long> {
    User findByUsername(String username);


}
