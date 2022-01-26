package fr.dosi.etron.jpa;


import javax.persistence.*;
import java.util.List;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;
    Double frais;
    @OneToMany(mappedBy = "abonnement")
    List<Tarifs> tarifs;

    public Abonnement() {
    }

    public Abonnement(Long id, String type, Double frais, List<Tarifs> tarifs) {
        this.id = id;
        this.type = type;
        this.frais = frais;
        this.tarifs = tarifs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Double getFrais() {
        return frais;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }

    public List<Tarifs> getTarifs() {
        return tarifs;
    }

    public void setTarifs(List<Tarifs> tarifs) {
        this.tarifs = tarifs;
    }
}
