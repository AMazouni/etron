package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Abonnement;
import fr.dosi.etron.jpa.Tarifs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "Tarifs")
public interface TarifDAO extends JpaRepository<Tarifs,Long> {


}
