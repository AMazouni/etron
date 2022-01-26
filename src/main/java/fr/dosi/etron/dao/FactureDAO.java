package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Client;
import fr.dosi.etron.jpa.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "Facture",collectionResourceRel = "Facture")
public interface FactureDAO extends JpaRepository<Facture,Long> {


}
