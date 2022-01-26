package fr.dosi.etron.services;

import fr.dosi.etron.jpa.Abonnement;

import java.util.List;

public interface AbonnementService {
    Abonnement save(Abonnement abonnement);
    List<Abonnement> getAll();

}
