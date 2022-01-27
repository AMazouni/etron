package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@RepositoryRestResource(path = "contrat")
public interface ContratDAO extends JpaRepository<Contrat,Long> {
    @Query("SELECT u.id FROM Contrat u WHERE u.client = :id")
    Collection<Contrat> findByUserId(Long id);


}
