package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "abonnementRest",collectionResourceRel = "Abonnem€nt")
public interface AbonnementDAO extends JpaRepository<Abonnement,Long> {

   Abonnement findFirstByType(String type);
}
