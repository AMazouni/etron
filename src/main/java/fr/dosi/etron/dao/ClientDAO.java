package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Client;
import fr.dosi.etron.jpa.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "Client",collectionResourceRel = "Client")
public interface ClientDAO extends JpaRepository<Client,Long> {
Client findByNomAndPrenom(String nom,String prenom);

}
