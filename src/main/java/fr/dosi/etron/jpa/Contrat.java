package fr.dosi.etron.jpa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateFin",nullable = true)
    Date dateFin;

    @ManyToOne(optional = false)
    Client client;
    @ManyToOne(optional = false)
    Abonnement abonnement;
    @OneToMany(mappedBy = "contrat")
    @JsonIgnoreProperties("contrat")
    List<Facture> factures;

    public Contrat() {
    }

    public Contrat(Long id, Date dateDebut, Date dateFin, Client client, Abonnement abonnement, List<Facture> factures) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.abonnement = abonnement;
        this.factures = factures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
}
