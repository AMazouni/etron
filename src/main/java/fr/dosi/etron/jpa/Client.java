package fr.dosi.etron.jpa;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Client {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;

    @Column(name="nom")
    String nom;
    @Column(name="prenom")
    String prenom;
    @Column(name="adresse")
    String adresse;
    @Column(name="nationalite")
    String nationalite;
    @Column(name="pays_residence")
    String paysResidence;
    @Column(name="Date_inscription")
    @Temporal(TemporalType.DATE)
    Date dateInscription;

    @OneToMany(mappedBy = "proprietaire")
    private List<Voiture> voitures;


    public Client() {
    }

    public Client(Long id, String nom, String prenom, String adresse, String nationalite, String paysResidence, Date dateInscription, List<Voiture> voitures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nationalite = nationalite;
        this.paysResidence = paysResidence;
        this.dateInscription = dateInscription;
        this.voitures = voitures;
    }
    public Client( String nom, String prenom, String adresse, String nationalite, String paysResidence, Date dateInscription, List<Voiture> voitures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nationalite = nationalite;
        this.paysResidence = paysResidence;
        this.dateInscription = dateInscription;
        this.voitures = voitures;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPaysResidence() {
        return paysResidence;
    }

    public void setPaysResidence(String paysResidence) {
        this.paysResidence = paysResidence;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
}
