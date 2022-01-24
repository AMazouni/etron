package fr.dosi.etron.jpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libellé) {
        this.libelle = libellé;
    }
}
