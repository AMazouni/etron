package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementDAO extends JpaRepository<Abonnement,Long> {


}
