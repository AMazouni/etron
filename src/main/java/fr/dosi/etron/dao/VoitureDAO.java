package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Contrat;
import fr.dosi.etron.jpa.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "Voiture",collectionResourceRel = "Voiture")
public interface VoitureDAO extends JpaRepository<Voiture,Long> {
List<Voiture> findByReferance(String Ref);

}
