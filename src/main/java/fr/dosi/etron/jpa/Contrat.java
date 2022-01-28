package fr.dosi.etron.jpa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(TemporalType.DATE)
    Calendar  dateDebut;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateFin",nullable = true)
    Calendar dateFin;

    @ManyToOne(optional = false)
    Client client;
    @ManyToOne(optional = false)
    Abonnement abonnement;
    @OneToMany(mappedBy = "contrat")
    @JsonIgnoreProperties("contrat")
    List<Facture> factures;

    public Contrat() {
    }

    public Contrat(Calendar  dateDebut, Calendar  dateFin, Client client, Abonnement abonnement) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.abonnement = abonnement;
    }

    public Contrat(Calendar  dateDebut, Calendar  dateFin, Client client, Abonnement abonnement, List<Facture> factures) {
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

    public Calendar  getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar  dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar  getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar  dateFin) {
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
